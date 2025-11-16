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
            company.text = job.CP_name
            title.text = job.job_name
            location.text = job.Location
            tagTime.text = "${ job.W_Hour }Hour"
            tagModel.text = "${job.Days}days in a week"
            salary.text = job.Salary

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
