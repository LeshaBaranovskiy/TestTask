package com.example.empattesttask.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.empattesttask.BuildConfig
import com.example.empattesttask.R
import com.example.empattesttask.common.prefs.SharedPreferencesHelper
import com.example.empattesttask.common.utils.result.asFailure
import com.example.empattesttask.common.utils.result.asSuccess
import com.example.empattesttask.common.utils.result.getErrorInfo
import com.example.empattesttask.common.utils.result.isSuccess
import com.example.empattesttask.data.local.dbentity.DBFavouriteCitiesEntity
import com.example.empattesttask.data.local.dbentity.DBWeatherEntity
import com.example.empattesttask.databinding.FragmentShowForecastBinding
import com.example.empattesttask.domain.model.entity.DayInfoEntity
import com.example.empattesttask.domain.model.entity.DayInfoMainInfoEntity
import com.example.empattesttask.domain.model.entity.DayInfoWeatherEntity
import com.example.empattesttask.domain.model.entity.DayInfoWindEntity
import com.example.empattesttask.domain.params.WeatherParams
import com.example.empattesttask.domain.viewmodel.ShowForecastViewModel
import com.example.empattesttask.presentation.adapter.ForecastAdapter
import com.example.empattesttask.presentation.dialog.DialogBuilder
import com.example.empattesttask.presentation.dialog.FromDbWarningDialog


class ShowForecastFragment : BaseFragment(R.layout.fragment_show_forecast),
    MenuProvider {
    private val binding by viewBinding<FragmentShowForecastBinding>()

    private val weatherViewModel: ShowForecastViewModel by viewModels { viewModelFactory }

    private lateinit var forecastAdapter: ForecastAdapter

    private var currentCity: String = ""

    private var dialog: FromDbWarningDialog? = null

    private var isFavourite: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        currentCity = arguments?.getString(ARG_CITY) ?: "London"
        SharedPreferencesHelper.setLastCity(requireActivity(), currentCity)

        isFavourite = arguments?.getBoolean(ARG_IS_FAVOURITE) ?: false

        initData()
        initRecycler()
        getData()
        handleOnBackPressed()

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initData() {
        binding.tvWeatherDescription.text = "Weather in ${currentCity.replaceFirstChar { it.uppercase() }}"
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Weather in ${currentCity.replaceFirstChar { it.uppercase() }}"
    }

    private fun initRecycler() {
        with(binding) {
            forecastAdapter = ForecastAdapter(requireContext())
            rvWeatherDays.adapter = forecastAdapter
            rvWeatherDays.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun getData() {
        weatherViewModel.getForecast(WeatherParams(
            currentCity,
            "40",
            BuildConfig.API_KEY
        )).observe(viewLifecycleOwner) { result ->
            when(result.isSuccess()) {
                true -> {
                    var i = 0
                    val weatherList: MutableList<DayInfoEntity> = mutableListOf()
                    for (j in 0..40) {
                        i++
                        if (i >= 8) {
                            weatherList.add(result.asSuccess().value.list[j])
                            i = 0
                        }
                    }
                    saveCitiesToDb(weatherList)
                    forecastAdapter.setWeatherList(weatherList)
                }

                false -> {
                    if (result.asFailure().getErrorInfo().message == "No connection!") {
                        weatherViewModel.getCityFromDB(currentCity).observe(viewLifecycleOwner) { result ->
                            if (result.isNotEmpty()) {
                                forecastAdapter.setWeatherList(
                                    mapDbEntityToEntity(result)
                                )
                                dialog = DialogBuilder.buildFromDbWarningDialog(requireContext()) {
                                    dialog?.dismiss()
                                }
                                dialog?.show()
                            } else {
                                binding.ivNoConnection.visibility = View.VISIBLE
                            }
                        }
                    }
                    if (result.asFailure().getErrorInfo().code == 404) {
                        binding.ivNotFoundCity.visibility = View.VISIBLE
                        binding.tvCityNotFoundLabel.visibility = View.VISIBLE
                    }
                    Log.d("GET_FORECAST", result.asFailure().getErrorInfo().message)
                    Log.d("GET_FORECAST_CODE", result.asFailure().getErrorInfo().code.toString())
                }
            }
        }
    }

    private fun handleOnBackPressed() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    parentFragmentManager.popBackStack()
                    SharedPreferencesHelper.setLastCity(requireActivity(), "")
                }
            }
            )
    }

    private fun saveCitiesToDb(dayInfoEntity :List<DayInfoEntity>) {
        weatherViewModel.getCityFromDB(currentCity).observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                insertCities(dayInfoEntity)
            } else {
                weatherViewModel.deleteCitiesFromDb(currentCity).observe(viewLifecycleOwner) {
                    insertCities(dayInfoEntity)
                }
            }
        }
    }

    private fun mapDbEntityToEntity(dbWeatherEntity: List<DBWeatherEntity>): List<DayInfoEntity> {
        return dbWeatherEntity.map { item ->
            DayInfoEntity(
                item.date,
                DayInfoMainInfoEntity(item.temperature.toFloat(), item.humidity),
                listOf(DayInfoWeatherEntity(0, "Weather title", item.description, item.iconName)),
                DayInfoWindEntity(item.windSpeed)
            )
        }
    }

    private fun mapEntityToDb(weatherEntity: List<DayInfoEntity>): List<DBWeatherEntity> {
        return weatherEntity.map { item ->
            DBWeatherEntity(
                city = currentCity,
                date = item.dt,
                description = item.weather[0].weatherDescription,
                temperature = item.main.temp.toInt(),
                windSpeed = item.wind.speed,
                humidity = item.main.humidity,
                iconName = item.weather[0].icon,
            )
        }
    }

    private fun insertCities(dayInfoEntity :List<DayInfoEntity>) {
        weatherViewModel.insertListToDb(
            mapEntityToDb(dayInfoEntity)
        ).observe(viewLifecycleOwner) {
            Log.d("saveCitiesToDb", "cities saved")
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu, menu)
        if (isFavourite) {
            menu.findItem(R.id.add).icon =
                requireContext().getDrawable(R.drawable.favourite_selected)
        } else {
            menu.findItem(R.id.add).icon =
                requireContext().getDrawable(R.drawable.favourive_unselected)
        }

    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            android.R.id.home -> {
                parentFragmentManager.popBackStack()
                SharedPreferencesHelper.setLastCity(requireActivity(), "")
                true
            }
            R.id.add -> {
                if (isFavourite) {
                    weatherViewModel.deleteFavouriteCitiesFromDb(currentCity.lowercase()).observe(viewLifecycleOwner) {
                        menuItem.icon = requireContext().getDrawable(R.drawable.favourive_unselected)
                        isFavourite = false
                    }
                } else {
                    weatherViewModel.insertFavouriteCityToDb(DBFavouriteCitiesEntity(city = currentCity.lowercase())).observe(viewLifecycleOwner) {
                        menuItem.icon = requireContext().getDrawable(R.drawable.favourite_selected)
                        isFavourite = true
                    }
                }
                true
            }
            else -> return false
        }

    }

    companion object {
        private const val ARG_CITY = "ARG_CITY"
        private const val ARG_IS_FAVOURITE = "ARG_IS_FAVOURITE"

        fun newInstance(city: String, isFavourite: Boolean): ShowForecastFragment {
            val bundle = Bundle()
            bundle.putString(ARG_CITY, city)
            bundle.putBoolean(ARG_IS_FAVOURITE, isFavourite)
            val fragment = ShowForecastFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}