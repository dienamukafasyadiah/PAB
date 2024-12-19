package com.example.fitplate_dienams

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        // Button to go to registration
        findViewById<Button>(R.id.create).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Button for Login to InputUserActivity
        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            startActivity(Intent(this, InputUserActivity::class.java))
        }
    }
}