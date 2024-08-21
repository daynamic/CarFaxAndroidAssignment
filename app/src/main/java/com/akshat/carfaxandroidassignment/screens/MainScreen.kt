package com.akshat.carfaxandroidassignment.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
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
            title = "Carfax",
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
    Text(text = data.toString())

}
