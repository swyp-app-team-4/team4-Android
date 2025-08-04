package com.example.swift.view.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boombim.android.R
import com.boombim.android.databinding.ItemLessBoomBimBinding
import com.example.domain.model.PlaceLessBoomBimModel

class PlaceLessBoomBimAdapter(private val items: List<PlaceLessBoomBimModel>) :
    RecyclerView.Adapter<PlaceLessBoomBimAdapter.PlaceViewHolder>() {

    inner class PlaceViewHolder(val binding: ItemLessBoomBimBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlaceLessBoomBimModel) {
            binding.textPlaceName.text = item.placeName
            binding.textTime.text = item.time

            val statusIconRes = when (item.status) {
                "congestion" -> R.drawable.icon_status_congestion
                "normal" -> R.drawable.icon_status_moderate
                "relaxed" -> R.drawable.icon_status_relaxation
                else -> R.drawable.icon_status_moderate
            }

            binding.iconStatus.setImageResource(statusIconRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLessBoomBimBinding.inflate(inflater, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}