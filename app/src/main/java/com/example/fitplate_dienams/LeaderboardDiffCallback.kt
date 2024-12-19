package com.example.fitplate_dienams

import androidx.recyclerview.widget.DiffUtil

class LeaderboardDiffCallback : DiffUtil.ItemCallback<LeaderboardItem>() {
    override fun areItemsTheSame(oldItem: LeaderboardItem, newItem: LeaderboardItem): Boolean {
        return oldItem.name == newItem.name && oldItem.level == newItem.level
    }

    override fun areContentsTheSame(oldItem: LeaderboardItem, newItem: LeaderboardItem): Boolean {
        return oldItem == newItem
    }
}