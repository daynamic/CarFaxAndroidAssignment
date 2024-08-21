package com.akshat.carfaxandroidassignment.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.akshat.carfaxandroidassignment.data.DataOrException
import com.akshat.carfaxandroidassignment.model.CarData
import com.akshat.carfaxandroidassignment.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: CarRepository) : ViewModel() {
    val data: MutableState<DataOrException<CarData, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))

    suspend fun getCarsData():
            DataOrException<CarData, Boolean, Exception> {
        return repository.getCarsData()
    }
}