package com.example.empattesttask.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.empattesttask.R
import com.example.empattesttask.common.prefs.SharedPreferencesHelper
import com.example.empattesttask.data.local.dbentity.DBFavouriteCitiesEntity
import com.example.empattesttask.databinding.FragmentSelectCityBinding
import com.example.empattesttask.domain.viewmodel.ShowForecastViewModel
import com.example.empattesttask.presentation.adapter.FavouriteCitiesAdapter
import com.example.empattesttask.presentation.navigation.FragmentNavigation

class SelectCityFragment : BaseFragment(R.layout.fragment_select_city) {

    private val binding by viewBinding<FragmentSelectCityBinding>()

    private lateinit var adapter: FavouriteCitiesAdapter

    private val weatherViewModel: ShowForecastViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkLastCity()
        setOnClickListeners()
        initAdapter()

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    private fun initAdapter() {
        adapter = FavouriteCitiesAdapter({ city ->
            FragmentNavigation.navigateToShowForecast( 
                parentFragmentManager,
                city,
                true
            )
        }, { city ->
            weatherViewModel.deleteFavouriteCitiesFromDb(city).observe(viewLifecycleOwner) {
                adapter.deleteCity(city)
                if (adapter.itemCount == 0) {
                    binding.rvFavouriteCities.visibility = View.GONE
                    binding.tvPlaceholderNoFavouriteCities.visibility = View.VISIBLE
                } else {
                    binding.rvFavouriteCities.visibility = View.VISIBLE
                    binding.tvPlaceholderNoFavouriteCities.visibility = View.GONE
                }
            }
        })
        binding.rvFavouriteCities.adapter = adapter
        binding.rvFavouriteCities.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        initFavouriteData()
    }

    private fun checkLastCity() {
        if (SharedPreferencesHelper.getLastCity(requireActivity()) != "") {
            handleNavigation(true)
        }
    }

    private fun initFavouriteData() {
        weatherViewModel.getFavouriteCitiesFromDB().observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                adapter.setFavouriteCitiesList(it.map { it.city }.toMutableList())
                binding.rvFavouriteCities.visibility = View.VISIBLE
                binding.tvPlaceholderNoFavouriteCities.visibility = View.GONE
            } else {
                binding.rvFavouriteCities.visibility = View.GONE
                binding.tvPlaceholderNoFavouriteCities.visibility = View.VISIBLE
            }
        }
    }

    private fun setOnClickListeners() {
        binding.btnShowWeather.setOnClickListener {
            handleNavigation(false)
        }
    }

    private fun handleNavigation(isFromPrefs: Boolean) {
        var compareText = if (isFromPrefs) {
            SharedPreferencesHelper.getLastCity(requireActivity())
        } else {
            binding.etCity.text.toString()
        }

        weatherViewModel.getFavouriteCitiesFromDB().observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                for (i in it.indices)
                    if (it[i].city == compareText.lowercase()) {
                        FragmentNavigation.navigateToShowForecast(
                            parentFragmentManager,
                            compareText,
                            true
                        )
                        break
                    } else if (i == it.size - 1) {
                        FragmentNavigation.navigateToShowForecast(
                            parentFragmentManager,
                            compareText,
                            false
                        )
                    }
            } else {
                FragmentNavigation.navigateToShowForecast(
                    parentFragmentManager,
                    compareText,
                    false
                )
            }
        }
    }

    companion object {
        fun newInstance() =
            SelectCityFragment()
    }
}