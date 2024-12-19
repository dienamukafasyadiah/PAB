package com.example.fitplate_dienams

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitplate_dienams.databinding.RecipeGuideBinding
import com.google.android.material.tabs.TabLayoutMediator

class RecipeActivity : AppCompatActivity() {

    private lateinit var binding: RecipeGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecipeGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RecipePagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Breakfast"
                1 -> "Lunch"
                2 -> "Dinner"
                3 -> "Snack"
                else -> null
            }
        }.attach()
    }
}
