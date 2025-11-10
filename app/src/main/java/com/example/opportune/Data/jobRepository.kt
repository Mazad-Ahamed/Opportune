package com.example.opportune.Data

import androidx.lifecycle.LiveData

class jobRepository(private val Dao : JobDao) {
   val allljobs : LiveData<List<JobEntity>>  = Dao.getAllItems()


    suspend fun insert(job : JobEntity) = Dao.insert(job)
    suspend fun update(job : JobEntity) = Dao.update(job)
    suspend fun delete(job : JobEntity) = Dao.delete(job)
}