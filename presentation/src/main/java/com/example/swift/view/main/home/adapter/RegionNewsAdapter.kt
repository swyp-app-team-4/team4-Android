package com.example.swift.view.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boombim.android.databinding.ItemRegionNewsBinding
import com.example.domain.model.RegionNewsModel

class RegionNewsAdapter(private val items: List<RegionNewsModel>) : RecyclerView.Adapter<RegionNewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ItemRegionNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RegionNewsModel) {
            binding.textTitle.text = item.title
            binding.textContent.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRegionNewsBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
