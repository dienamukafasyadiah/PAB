package com.example.fitplate_dienams

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Get data from Intent
        val tujuanDiet = intent.getStringExtra("TUJUAN_DIET") ?: "-"
        val olahraga = intent.getStringExtra("OLAHRAGA") ?: "-"
        val gender = intent.getStringExtra("GENDER") ?: "-"
        val tingkatan = intent.getStringExtra("TINGKATAN") ?: "-"
        val usia = intent.getStringExtra("USIA") ?: "-"
        val konsumsiAir = intent.getStringExtra("KONSUMSI_AIR") ?: "-"
        val jumlahMakan = intent.getStringExtra("JUMLAH_MAKAN") ?: "-"
        val tinggiBadan = intent.getStringExtra("TINGGI_BADAN") ?: "-"
        val beratBadan = intent.getStringExtra("BERAT_BADAN") ?: "-"
        val targetBB = intent.getStringExtra("TARGET_BB") ?: "-"

        // Calculate BMI if height and weight are available
        val bmi = if (tinggiBadan != "-" && beratBadan != "-") {
            val height = tinggiBadan.toFloat() / 100 // convert to meters
            val weight = beratBadan.toFloat()
            String.format("%.1f", weight / (height * height))
        } else {
            "-"
        }

        // Display all data
        findViewById<TextView>(R.id.tvTujuanDiet).text = "Tujuan Diet: $tujuanDiet"
        findViewById<TextView>(R.id.tvOlahraga).text = "Aktivitas Olahraga: $olahraga"
        findViewById<TextView>(R.id.tvGender).text = "Gender: $gender"
        findViewById<TextView>(R.id.tvTingkatan).text = "Tingkatan Program: $tingkatan"
        findViewById<TextView>(R.id.tvUsia).text = "Usia: $usia tahun"
        findViewById<TextView>(R.id.tvKonsumsiAir).text = "Konsumsi Air: $konsumsiAir liter/hari"
        findViewById<TextView>(R.id.tvJumlahMakan).text = "Jumlah Makan: $jumlahMakan kali/hari"
        findViewById<TextView>(R.id.tvTinggiBadan).text = "Tinggi Badan: $tinggiBadan cm"
        findViewById<TextView>(R.id.tvBeratBadan).text = "Berat Badan: $beratBadan kg"
        findViewById<TextView>(R.id.tvTargetBB).text = "Target Berat Badan: $targetBB kg"
        findViewById<TextView>(R.id.tvBMI).text = "BMI: $bmi"

        // Tambahkan kode untuk tombol Mulai Sekarang
        val btnMulaiSekarang: Button = findViewById(R.id.btnMulaiSekarang)
        btnMulaiSekarang.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)

            // Bersihkan semua activity di atas dan jadikan HomeActivity sebagai top task
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)

            // Memulai HomeActivity
            startActivity(intent)

        }
    }
}