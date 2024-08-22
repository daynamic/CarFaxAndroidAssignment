package com.akshat.carfaxandroidassignment.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.akshat.carfaxandroidassignment.data.DataOrException
import com.akshat.carfaxandroidassignment.model.CarData
import com.akshat.carfaxandroidassignment.model.Listings
import com.akshat.carfaxandroidassignment.widgets.CarDetailsRow
import com.akshat.carfaxandroidassignment.widgets.CarfaxAppBar


@Composable
fun DetailsScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel(),
    selectedCarListing: Listings
) {
    DetailsScaffold(
        car = selectedCarListing,
        navController = navController
    )
}

@Composable
fun DetailsScaffold(car: Listings, navController: NavController) {
    Scaffold(topBar = {
        CarfaxAppBar(
            title = car.year.toString() + " " + car.make + " " + car.model + " " + car.trim,
            icon = Icons.Default.ArrowBack,
            isMainScreen = false,
            navController = navController,
            elevation = 7.dp
        )
    }) { it ->
        Surface(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            DetailsContent(data = car, navController = navController)
        }
    }
}

@Composable
fun DetailsContent(data: Listings, navController: NavController) {
    CarDetailsRow(car = data, false)
}

