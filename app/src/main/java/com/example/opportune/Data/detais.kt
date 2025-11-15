package com.example.opportune.Data

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.opportune.R
import com.example.opportune.databinding.ActivityDetaisBinding

class detais : AppCompatActivity() {
    private lateinit var binding : ActivityDetaisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetaisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val News = intent.getSerializableExtra("NewsData") as? JobEntity

        News?.let {
            binding.tvCompanyName.text = it.CP_name
            binding.tvJobName.text = it.job_name
            binding.tvSalary.text=it.Salary
            binding.tvLocation.text = it.Location
            binding.tvEmail.text = it.Email
            binding.tvPhone.text = it.Phone
            binding.tvWorkingHour.text = it.W_Hour
            binding.tvDays.text = it.Days
            binding.ratingBar.rating = it.rating

        }
    }
}