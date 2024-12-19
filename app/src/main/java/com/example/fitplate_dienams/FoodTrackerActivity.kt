package com.example.fitplate_dienams

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FoodTrackerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_tracker_activity)

        fun onBackPressed() {
            super.onBackPressed() // Menyelesaikan aktivitas ini dan kembali ke layar sebelumnya
        }
        // Menangani klik tombol "Tambah Makanan"
        val addFoodButton: Button = findViewById(R.id.addFoodButton)

        addFoodButton.setOnClickListener {
            // Membuka FoodJournalActivity
            val intent = Intent(this, FoodJournalActivity::class.java)
            startActivity(intent)
        }
    }
}
