package com.example.opportune.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


data class JobItem(
    val title: String,
    val description: String,
    val company: String,
    val rating: Float,
    val phone: String // for call intent
)

@Entity("job_table")
data class JobEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int=0,
    var CP_name : String,
    var job_name : String,
    var Salary : String,
    var W_Hour : String,
    var Location : String,
    var Days : String,
    var Phone : String,
    var Email : String,
    var rating: Float,

) : Serializable