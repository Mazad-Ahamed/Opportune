package com.example.opportune

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.opportune.Data.JobEntity
import com.example.opportune.databinding.RecyclerItemOneBinding
class SugAdapter(private var sugjoblist: List<JobEntity>)
    : RecyclerView.Adapter<SugAdapter.SugViewHolder>() {

    class SugViewHolder(val binding: RecyclerItemOneBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SugViewHolder {
        val binding = RecyclerItemOneBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SugViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SugViewHolder, position: Int) {
        val sugjob = sugjoblist[position]
        with(holder.binding) {
            tvCompany.text = sugjob.CP_name
            tvDescription.text = sugjob.Location
            tvJobTitle.text = sugjob.job_name
            ratingBar.rating = sugjob.rating
        }
    }

    override fun getItemCount(): Int = sugjoblist.size

    // 🔥 Allows refreshing data after adapter is created
    fun updateData(newList: List<JobEntity>) {
        sugjoblist = newList
        notifyDataSetChanged()
    }
}
