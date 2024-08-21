package com.akshat.carfaxandroidassignment.model

data class Listings(
    val bodytype: String,
    val currentPrice: Int,
    val dealer: Dealer,
    val drivetype: String,
    val engine: String,
    val exteriorColor: String,
    val fuel: String,
    val id: String,
    val imageCount: Int,
    val images: Images,
    val interiorColor: String,
    val listingStatus: String,
    val make: String,
    val mileage: Int,
    val model: String,
    val mpgCity: Int,
    val mpgHighway: Int,
    val oneOwner: Boolean,
    val ownerHistory: OwnerHistory,
    val transmission: String,
    val trim: String,
    val year: Int
)