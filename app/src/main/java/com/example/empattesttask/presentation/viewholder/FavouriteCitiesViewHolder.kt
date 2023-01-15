package com.example.empattesttask.presentation.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.empattesttask.databinding.ItemFavouriteCityBinding

class FavouriteCitiesViewHolder(
    private val binding: ItemFavouriteCityBinding,
    private val onCityClick: (city: String) -> Unit,
    private val onDeleteClick: (city: String) -> Unit
): ViewHolder(binding.root) {

    fun bind(city: String) {
        binding.tvCityName.text = city.replaceFirstChar { it.uppercase() }

        binding.tvCityName.setOnClickListener {
            onCityClick.invoke(city)
        }

        binding.ivDelete.setOnClickListener {
            onDeleteClick.invoke(city)
        }
    }

    companion object {
        fun from(parent: ViewGroup, onCityClick: (city: String) -> Unit, onDeleteClick: (city: String) -> Unit): FavouriteCitiesViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemFavouriteCityBinding.inflate(inflater, parent, false)
            return FavouriteCitiesViewHolder(binding, onCityClick, onDeleteClick)
        }
    }
}