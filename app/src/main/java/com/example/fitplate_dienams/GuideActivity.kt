package com.example.fitplate_dienams

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GuideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guide_activity) // Replace with your actual layout file

        fun onBackPressed() {
            super.onBackPressed() // Menyelesaikan aktivitas ini dan kembali ke layar sebelumnya
        }
    }


}