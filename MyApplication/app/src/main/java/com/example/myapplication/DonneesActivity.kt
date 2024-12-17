package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDonneesBinding


class DonneesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDonneesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDonneesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "DONNÉES"
        val AndroidVer = intent.getStringExtra("Android")
        binding.AndroidVer.text = AndroidVer

        val NomVer = intent.getStringExtra("Nom")
        binding.NomDeVer.text = NomVer
    }
}