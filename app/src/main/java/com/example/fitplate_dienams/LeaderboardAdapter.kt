package com.example.fitplate_dienams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fitplate_dienams.databinding.ItemLeaderboardBinding

class LeaderboardAdapter : ListAdapter<LeaderboardItem, LeaderboardAdapter.ViewHolder>(LeaderboardDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLeaderboardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemLeaderboardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LeaderboardItem) {
            binding.apply {
                playerName.text = item.name
                playerRole.text = item.role
                playerLevel.text = "Level ${item.level}"
            }
        }
    }
}