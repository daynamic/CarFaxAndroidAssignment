package com.akshat.carfaxandroidassignment.screens

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.akshat.carfaxandroidassignment.data.DataOrException
import com.akshat.carfaxandroidassignment.model.CarData
import com.akshat.carfaxandroidassignment.model.Listings
import com.akshat.carfaxandroidassignment.widgets.CarDetailsRow
import com.akshat.carfaxandroidassignment.widgets.CarfaxAppBar


@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel()
) {

    val carData = produceState<DataOrException<CarData, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {

        value = mainViewModel.getCarsData()

    }.value

    if (carData.loading == true)
        CircularProgressIndicator()
    else if (carData.data != null)
        MainScaffold(cars = carData.data!!, navController)

}

@Composable
fun MainScaffold(cars: CarData, navController: NavController) {
    Scaffold(topBar = {
        CarfaxAppBar(
            title = "CARFAX",
            icon = Icons.Default.ArrowBack,
            navController = navController,
            elevation = 7.dp
        )
    }) { it ->
        Surface(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            MainContent(data = cars)
        }
    }
}

@Composable
fun MainContent(data: CarData) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFFEEF1EF)
    ) {
        val context = LocalContext.current
        LazyColumn(
            modifier = Modifier.padding(2.dp),
            contentPadding = PaddingValues(1.dp)
        ) {
            items(items = data.listings) { item: Listings ->
                CarDetailsRow(car = item){car ->
                    Toast.makeText(context, "clicked on $car", Toast.LENGTH_SHORT).show()

                }
            }
        }

    }

}


