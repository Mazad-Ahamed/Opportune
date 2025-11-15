package com.example.opportune.UI_Design

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.opportune.Adapters.JobONEAdapter
import com.example.opportune.Data.JobEntity
import com.example.opportune.Data.JobItem
import com.example.opportune.Data.JobViewModel
import com.example.opportune.Data.detais
import com.example.opportune.SugAdapter
import com.example.opportune.databinding.FragmentHomeBinding
import kotlin.getValue


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var Aadapter: JobONEAdapter
    private lateinit var joblist : List<JobItem>

    private  var joblistone : List<JobEntity> = emptyList()

    private lateinit var AdapterOne : SugAdapter




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = FragmentHomeBinding.inflate(inflater, container, false)

        loaddata()
AdapterOne = SugAdapter(joblistone){selectedArticle ->
    val intent =
        Intent(requireContext(), detais::class.java)
    intent.putExtra("NewsData", selectedArticle)
    startActivity(intent)
}

        binding.SuggestedjobRecycler.apply {
            layoutManager=
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
                adapter = this@HomeFragment.AdapterOne
        }








        Aadapter = JobONEAdapter(joblist)

        binding.recentjobRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = this@HomeFragment.Aadapter
        }



        return binding.root
    }

    private fun loaddata(){
         joblist = listOf(
            JobItem("Android Developer", "Build and maintain Android apps", "OpenAI", 4.5f, "+123456789"),
             JobItem("UI Designer", "Design intuitive mobile interfaces", "Google", 4.0f, "+987654321"),
             JobItem("Android Developer", "Build and maintain Android apps", "OpenAI", 4.5f, "+123456789"),
        JobItem("UI Designer", "Design intuitive mobile interfaces", "Google", 4.0f, "+987654321"),
        JobItem("Backend Engineer", "Develop and optimize RESTful APIs", "Amazon", 4.3f, "+14155550123"),
        JobItem("Data Analyst", "Analyze data trends to support business growth", "Netflix", 4.6f, "+14155550234"),
        JobItem("iOS Developer", "Build and support iOS mobile applications", "Apple", 4.8f, "+14155550345"),
        JobItem("Project Manager", "Lead cross-functional teams to deliver projects", "Microsoft", 4.2f, "+14155550456"),
        JobItem("QA Tester", "Test software for bugs and ensure stability", "Spotify", 4.1f, "+14155550567"),
        JobItem("Frontend Developer", "Develop modern web interfaces using React", "Meta", 4.4f, "+14155550678"),
        JobItem("DevOps Engineer", "Automate deployments and monitor infrastructure", "Tesla", 4.7f, "+14155550789"),
        JobItem("Customer Support Specialist", "Assist users with app-related queries", "Adobe", 4.0f, "+14155550890")


        )
    }
}


