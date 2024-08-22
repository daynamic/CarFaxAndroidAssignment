package com.akshat.carfaxandroidassignment.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.akshat.carfaxandroidassignment.model.Listings
import com.akshat.carfaxandroidassignment.screens.DetailsScreen
import com.akshat.carfaxandroidassignment.screens.MainScreen
import com.akshat.carfaxandroidassignment.screens.MainViewModel
import com.google.gson.Gson
import java.net.URLDecoder

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

        composable(
            CarfaxScreens.DetailScreen.name + "/{selectedCarListing}",
            arguments = listOf(navArgument(name = "selectedCarListing") {
                type = NavType.StringType
                defaultValue = ""
            })
        ) { _ ->
            val mainViewModel = hiltViewModel<MainViewModel>()
            val car =
                navController.currentBackStackEntry?.arguments?.getString("selectedCarListing")
            val selectedCarListingDecoded = URLDecoder.decode(car, "utf-8")
            val selectedCarListing =
                Gson().fromJson(selectedCarListingDecoded, Listings::class.java)

            DetailsScreen(
                navController = navController,
                mainViewModel = mainViewModel,
                selectedCarListing = selectedCarListing
            )
        }

    }
}