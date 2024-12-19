package com.example.fitplate_dienams

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitplate_dienams.databinding.LeaderboardActivityBinding
import com.squareup.picasso.Picasso

class LeaderboardActivity : AppCompatActivity() {
    private lateinit var binding: LeaderboardActivityBinding
    private lateinit var adapter: LeaderboardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LeaderboardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadLeaderboardData()
    }

    private fun setupRecyclerView() {
        adapter = LeaderboardAdapter()
        binding.leaderboardRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@LeaderboardActivity)
            this.adapter = this@LeaderboardActivity.adapter
        }
    }

    private fun loadLeaderboardData() {
        val leaderboardItems = listOf(
            LeaderboardItem("Sebastian", "Senior", 50),
            LeaderboardItem("Sebastian", "Senior", 48),
            LeaderboardItem("Sebastian", "Senior", 45),
            LeaderboardItem("Sebastian", "Senior", 40),
            LeaderboardItem("Sebastian", "Senior", 30),
            LeaderboardItem("Sebastian", "Junior", 30)
        )
        adapter.submitList(leaderboardItems)
    }

    private fun loadTopThreeImages() {
        // Load first place image
        Picasso.get()
            .load("https://picsum.photos/200")
            .transform(CircleTransform())
            .into(binding.firstPlaceImage)

        // Load second place image
        Picasso.get()
            .load("https://picsum.photos/201")
            .transform(CircleTransform())
            .into(binding.secondPlaceImage)

        // Load third place image
        Picasso.get()
            .load("https://picsum.photos/202")
            .transform(CircleTransform())
            .into(binding.thirdPlaceImage)
    }
}