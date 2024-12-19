package com.example.fitplate_dienams

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        // Button to go back to login
        findViewById<Button>(R.id.LoginNow).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Close the registration activity
        }
    }
}