package com.example.fitplate_dienams

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class InputUserActivity : AppCompatActivity() {
    private lateinit var familiarDropdown: MaterialAutoCompleteTextView
    private lateinit var olahragaDropdown: MaterialAutoCompleteTextView
    private lateinit var genderDropdown: MaterialAutoCompleteTextView
    private lateinit var tingkatanDropdown: MaterialAutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_user_activity)

        setupDropdowns()
        setupSubmitButton()
    }

    private fun setupDropdowns() {
        // Dropdown Tujuan Diet
        val familiarOptions = arrayOf("Turunin bb", "Jaga bb", "Naikin bb")
        val familiarAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, familiarOptions)
        familiarDropdown = findViewById(R.id.dropdownTujuanDiet)
        familiarDropdown.setAdapter(familiarAdapter)

        // Dropdown Seberapa Sering Berolahraga
        val olahragaOptions = arrayOf(
            "sedikit atau tidak pernah",
            "Olahraga ringan (1-3 kali/minggu)",
            "Olahraga sedang (3-5 kali/minggu)",
            "Olahraga berat (6-7 kali/minggu)"
        )
        val olahragaAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, olahragaOptions)
        olahragaDropdown = findViewById(R.id.dropdownOlahraga)
        olahragaDropdown.setAdapter(olahragaAdapter)

        // Dropdown Gender
        val genderOptions = arrayOf("Laki-laki", "Perempuan")
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, genderOptions)
        genderDropdown = findViewById(R.id.dropdownGender)
        genderDropdown.setAdapter(genderAdapter)

        // Dropdown Tingkatan
        val tingkatanOptions = arrayOf(
            "Mudah (seminggu turun/naik 0.2-0.3 kg)",
            "Normal (seminggu turun/naik 0.4-0.5 kg)",
            "Sulit (seminggu turun/naik 0.6-0.8kg)"
        )
        val tingkatanAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, tingkatanOptions)
        tingkatanDropdown = findViewById(R.id.dropdownTingkatan)
        tingkatanDropdown.setAdapter(tingkatanAdapter)
    }

    private fun setupSubmitButton() {
        findViewById<Button>(R.id.buttonDapatkan).setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("TUJUAN_DIET", familiarDropdown.text.toString())
                putExtra("OLAHRAGA", olahragaDropdown.text.toString())
                putExtra("GENDER", genderDropdown.text.toString())
                putExtra("TINGKATAN", tingkatanDropdown.text.toString())
                putExtra("USIA", findViewById<EditText>(R.id.editTextUsia).text.toString())
                putExtra("KONSUMSI_AIR", findViewById<EditText>(R.id.editTextAir).text.toString())
                putExtra("JUMLAH_MAKAN", findViewById<EditText>(R.id.editTextMakan).text.toString())
                putExtra("TINGGI_BADAN", findViewById<EditText>(R.id.editTextTinggi).text.toString())
                putExtra("BERAT_BADAN", findViewById<EditText>(R.id.editTextBerat).text.toString())
                putExtra("TARGET_BB", findViewById<EditText>(R.id.editTextTarget).text.toString())
            }
            startActivity(intent)
        }
    }
}