package com.example.opportune

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.opportune.Data.JobEntity
import com.example.opportune.databinding.AddJobListBinding


class JobAdapter(
    private var jobList: List<JobEntity>,
    private val onEditClick: (JobEntity) -> Unit,
    private val onDeleteClick: (JobEntity) -> Unit
) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    inner class JobViewHolder(val binding: AddJobListBinding ) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = AddJobListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        with(holder.binding) {
            tvCompanyName.text = job.CP_name
            tvJobTitle.text = job.job_name
            tvLocation.text = job.Location

            btnEdit.setOnClickListener { onEditClick(job) }
            btnDelete.setOnClickListener { onDeleteClick(job) }
        }
    }

    override fun getItemCount(): Int = jobList.size


    fun updateList(newList: List<JobEntity>) {
        jobList = newList
        notifyDataSetChanged()
    }
}
