package com.akshat.carfaxandroidassignment.network

import com.akshat.carfaxandroidassignment.model.CarData
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface CarsDataApi {
    @GET(value = "assignment.json")
    suspend fun getCarData(): CarData
}