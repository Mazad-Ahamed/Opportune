package com.example.opportune.Data



data class JobItem(
    val title: String,
    val description: String,
    val company: String,
    val rating: Float,
    val phone: String // for call intent
)
