package com.example.opportune

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.opportune.Data.JobEntity
import com.example.opportune.databinding.RecyclerItemOneBinding

class SugAdapter(private val joblistone : List<JobEntity>,
                 private val setonClick: (JobEntity) -> Unit
    ) : RecyclerView.Adapter<SugAdapter.sugViewHolder> (){
    class sugViewHolder(val binding: RecyclerItemOneBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SugAdapter.sugViewHolder {
        val binding = RecyclerItemOneBinding.inflate(LayoutInflater.from(parent.context),parent,false)
      return  sugViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SugAdapter.sugViewHolder, position: Int) {

        val sugjob = joblistone[position]
        with(holder.binding){
            tvJobTitle.text=sugjob.job_name
            tvDescription.text=sugjob.Location
            tvCompany.text=sugjob.CP_name
            ratingBar.rating=sugjob.rating

        }
        holder.itemView.setOnClickListener {
            setonClick(sugjob)
        }

    }

    override fun getItemCount(): Int {
        return joblistone.size
    }
}