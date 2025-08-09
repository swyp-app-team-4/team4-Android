package com.example.swift.view.main.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boombim.android.R
import com.boombim.android.databinding.ItemInterestsPlaceBinding
import com.boombim.android.databinding.ItemNaverSearchBinding
import com.example.domain.model.InterestsPlaceModel
import com.example.domain.model.Place
import com.example.swift.view.main.home.adapter.InterestsPlaceAdapter

class SearchNoticeAdapter (private val items: List<Place>) :
    RecyclerView.Adapter<SearchNoticeAdapter.PlaceViewHolder>() {

    inner class PlaceViewHolder(val binding: ItemNaverSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Place) {
            binding.textPlaceName.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNaverSearchBinding.inflate(inflater, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}