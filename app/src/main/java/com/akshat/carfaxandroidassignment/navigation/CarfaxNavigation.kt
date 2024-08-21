package com.akshat.carfaxandroidassignment.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akshat.carfaxandroidassignment.screens.MainScreen
import com.akshat.carfaxandroidassignment.screens.MainViewModel

@Composable
fun CarfaxNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = CarfaxScreens.MainScreen.name
    ) {
        composable(CarfaxScreens.MainScreen.name) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(
                navController = navController,
                mainViewModel
            )
        }

    }
}