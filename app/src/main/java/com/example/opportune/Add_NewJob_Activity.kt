package com.example.opportune

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.opportune.Data.JobEntity
import com.example.opportune.Data.JobViewModel
import com.example.opportune.databinding.ActivityAddNewJobBinding
import kotlin.getValue

class Add_NewJob_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNewJobBinding

    private val jobViewModel: JobViewModel by viewModels()

    private var existingjob: JobEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddNewJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

        existingjob = intent.getSerializableExtra("item") as? JobEntity
        existingjob?.let {
            binding.inputCompanyName.setText(it.CP_name)
            binding.inputJobName.setText(it.job_name)
            binding.inputLocation.setText(it.Location)
            binding.inputEmail.setText(it.Email)
            binding.inputPhoneNumber.setText(it.Phone)
            binding.inputSalary.setText(it.Salary)
            binding.inputWorkHour.setText(it.W_Hour)
            binding.inputWorkingDays.setText(it.Days)
            binding.ratingBar.rating = it.rating


        }

        binding.btnSave.setOnClickListener {
            var CPname = binding.inputCompanyName.text.toString().trim()
            val J_name = binding.inputJobName.text.toString().trim()
            val Salary = binding.inputSalary.text.toString().trim()
            val Email = binding.inputEmail.text.toString().trim()
            val Phone = binding.inputPhoneNumber.text.toString().trim()
            val Location = binding.inputLocation.text.toString().trim()
            val W_Hour = binding.inputWorkHour.text.toString().trim()
            val Days = binding.inputWorkingDays.text.toString().trim()
            val ratings = binding.ratingBar.rating



            if (CPname.isNotEmpty() && J_name.isNotEmpty()) {
                if (existingjob == null) {
                    jobViewModel.insert(JobEntity(0,CPname,J_name,Salary,W_Hour,Location,Days,Phone,Email,ratings))
                } else {
                    existingjob!! .CP_name = CPname
                    existingjob!!.job_name= J_name
                    existingjob!! .Phone = Phone
                    existingjob!!.Email= Email
                    existingjob!! .Location = Location
                    existingjob!!.Salary= Salary
                    existingjob!! .Days = Days
                    existingjob!!.W_Hour= W_Hour
                    existingjob!! .rating = ratings

                    jobViewModel.update(existingjob!!)
                }
                finish()
            }
        }
    }
}