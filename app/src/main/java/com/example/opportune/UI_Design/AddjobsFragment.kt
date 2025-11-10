package com.example.opportune.UI_Design

import android.content.Intent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.opportune.Add_NewJob_Activity
import com.example.opportune.Data.JobEntity
import com.example.opportune.Data.JobViewModel
import com.example.opportune.JobAdapter
import com.example.opportune.R
import com.example.opportune.databinding.FragmentAddjobsBinding
import com.example.opportune.databinding.FragmentBookmarkBinding
import kotlin.getValue

class AddjobsFragment : Fragment() {
    private lateinit var binding : FragmentAddjobsBinding
    private lateinit var adapter: JobAdapter
    private val itemViewModel: JobViewModel by viewModels()


    private val editAddLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddjobsBinding.inflate(inflater, container, false)
        adapter = JobAdapter(listOf(),
            onEditClick = { item -> editItem(item) },
            onDeleteClick = { item -> itemViewModel.delete(item) }
        )

        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = adapter

        // Observe DB data (LiveData)
        itemViewModel.alljobs.observe(viewLifecycleOwner) { list ->
            adapter.updateList(list)
        }

        binding.fabButton.setOnClickListener {
            val intent = Intent(requireContext(), Add_NewJob_Activity::class.java)
            editAddLauncher.launch(intent)
        }



        return binding.root
    }
    private fun editItem(job: JobEntity) {
        val intent = Intent(requireContext(), Add_NewJob_Activity::class.java)
        intent.putExtra("item", job)
        editAddLauncher.launch(intent)
    }


}