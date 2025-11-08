package com.example.opportune.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.opportune.Data.JobItem
import com.example.opportune.databinding.RecyclerItemTwoBinding


class JobAdapter(
    private val jobList: List<JobItem>,
  //  private val onCallClick: (String) -> Unit
) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    inner class JobViewHolder(val binding: RecyclerItemTwoBinding ) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = RecyclerItemTwoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        with(holder.binding) {
            tvJobTitle.text = job.title
            tvDescription.text = job.description
            tvCompany.text = job.company
            ratingBar.rating = job.rating

         //   ivCall.setOnClickListener {
       //         onCallClick(job.phone)
         //   }
        }
    }

    override fun getItemCount() = jobList.size
}