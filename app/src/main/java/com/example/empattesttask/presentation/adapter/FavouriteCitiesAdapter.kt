package com.example.empattesttask.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.empattesttask.presentation.viewholder.FavouriteCitiesViewHolder

class FavouriteCitiesAdapter(
    private val onCityClick: (city: String) -> Unit,
    private val onDeleteClick: (city: String) -> Unit
): Adapter<FavouriteCitiesViewHolder>() {
    private var favouriteCitiesList: MutableList<String> = mutableListOf()

    fun setFavouriteCitiesList(favouriteCitiesList: MutableList<String>) {
        this.favouriteCitiesList = favouriteCitiesList
        notifyItemRangeChanged(0, favouriteCitiesList.size)
    }

    fun deleteCity(city: String) {
        favouriteCitiesList.remove(city)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteCitiesViewHolder {
        return FavouriteCitiesViewHolder.from(parent, onCityClick, onDeleteClick)
    }

    override fun onBindViewHolder(holder: FavouriteCitiesViewHolder, position: Int) {
        holder.bind(favouriteCitiesList[position])
    }

    override fun getItemCount(): Int =
        favouriteCitiesList.size
}