package com.example.swift.view.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boombim.android.R
import com.boombim.android.databinding.ItemBoomBimBinding
import com.boombim.android.databinding.ItemLessBoomBimBinding
import com.example.domain.model.PlaceBoomBimModel
import com.example.domain.model.PlaceLessBoomBimModel

class PlaceBoomBimAdapter (private val items: List<PlaceBoomBimModel>) :
    RecyclerView.Adapter<PlaceBoomBimAdapter.PlaceViewHolder>() {

    inner class PlaceViewHolder(val binding: ItemBoomBimBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlaceBoomBimModel) {
            binding.textPlaceName.text = item.placeName
            binding.textTime.text = item.time
            binding.textPlaceAddress.text = item.placeAddress

            val statusIconRes = when (item.status) {
                "congestion" -> R.drawable.icon_status_congestion
                "normal" -> R.drawable.icon_status_moderate
                "relaxed" -> R.drawable.icon_status_relaxation
                else -> R.drawable.icon_status_moderate
            }
            val ranking = when(item.ranking){
                1 -> R.drawable.icon_rank1
                2 -> R.drawable.icon_rank2
                3 -> R.drawable.icon_rank3
                4 -> R.drawable.icon_rank4
                else -> R.drawable.icon_rank5
            }
            binding.iconRank.setImageResource(ranking)

            binding.iconStatus.setImageResource(statusIconRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBoomBimBinding.inflate(inflater, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}