package com.example.insuranccetest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.insuranccetest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.buttonRes.setOnClickListener { reset() }
        binding.buttonWeb.setOnClickListener { web() }
        binding.buttonSub.setOnClickListener { sub() }
        setContentView(binding.root)

    }

    private fun sub() {


        val name = binding.editName.text.toString().trim()
       // val campus = binding.spinnerCampus.selectedItem as String

        val campus = binding.spinnerCampus.selectedItem.toString()

        val cgpa = binding.editCGPA.text.toString().toDoubleOrNull() ?: -1.0

        if (name == "") {
            toast("Invalid name")
            return
        }

        if(cgpa < 0.0000 || cgpa > 4.0000){
            toast("Invalid cgpa")
            return
        }

        var award = ""
        var prize = 0.00

        when{
            cgpa >= 3.75 -> {award = "Dinstiction"; prize = 100.00}
            cgpa >= 2.70 -> {award = "Merit"; prize = 50.00}
            cgpa >= 2.00 -> {award = "Pass"; prize = 0.00}
            else -> {award = "fail"; prize = 0.00}
        }

        val intent = Intent(this, SubActivity::class.java).putExtra("name", name)
            .putExtra("campus", campus)
            .putExtra("cgpa", cgpa)
            .putExtra("award", award)
            .putExtra("ewq", prize)

        startActivity(intent)

    }

    private fun reset() {

        binding.editName.text = null
        binding.spinnerCampus.setSelection(0)
        binding.editCGPA.text = null
        binding.editName.requestFocus()
    }

    private fun toast(msg: String){
Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }

    private fun web() {
        val uri = Uri.parse("https://www.tarc.edu.my")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)

    }
}