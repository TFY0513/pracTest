package com.example.insuranccetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.insuranccetest.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubBinding.inflate(layoutInflater)


        setContentView(binding.root)

        binding.buttonClose1.setOnClickListener { finish() }

        // val name = intent.getStringExtra("name") ?: ""
        //or
        val name = intent.getStringExtra("name")
        val campus = intent.getStringExtra("campus") ?: ""
        val cgpa = intent.getDoubleExtra("cgpa", 0.00)
        val award = intent.getStringExtra("award") ?: ""
        val prize = intent.getDoubleExtra("prize", 0.00)

        binding.textViewOutput.text = """
            Name : $name
            Campus : $campus
              CGPA : ${"%.4f".format(cgpa)}
            award : $award
              prize : ${"%.2f".format(prize)}
           
            
        """.trimIndent()

    }


}