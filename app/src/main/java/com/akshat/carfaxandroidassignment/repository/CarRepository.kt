package com.akshat.carfaxandroidassignment.repository

import android.util.Log
import com.akshat.carfaxandroidassignment.data.DataOrException
import com.akshat.carfaxandroidassignment.model.CarData
import com.akshat.carfaxandroidassignment.network.CarsDataApi
import javax.inject.Inject

class CarRepository @Inject constructor(private val api: CarsDataApi) {
    suspend fun getCarsData(): DataOrException<CarData, Boolean, Exception> {
        val response = try {
            api.getCarData()
        } catch (e: Exception) {
            Log.d("GET", "getCarDataError : $e")
            return DataOrException(e = e)
        }
        Log.d("INSIDE", "getCarData : $response")
        return DataOrException(data = response)
    }
}