package com.akshat.carfaxandroidassignment.model

data class OwnerHistory(
    val history: List<History>,
    val icon: String,
    val iconUrl: String,
    val text: String
)