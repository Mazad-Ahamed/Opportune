package com.example.opportune.Data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class JobViewModel(application: Application): AndroidViewModel(application) {

    private val repository :jobRepository

    val alljobs : LiveData<List<JobEntity>>

    init {
        val dao = APPDatabase.getDatabase(application).jobdao()
        repository = jobRepository(dao)
        alljobs =repository.allljobs
    }

    fun insert(job: JobEntity) = viewModelScope.launch { repository.insert(job) }
    fun update(job: JobEntity) = viewModelScope.launch { repository.update(job) }
    fun delete(job: JobEntity) = viewModelScope.launch { repository.delete(job) }
}





