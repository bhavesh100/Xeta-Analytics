package com.bhavesh.xetaanalyticsassignment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bhavesh.xetaanalyticsassignment.FoodInfo
import com.bhavesh.xetaanalyticsassignment.HomePage

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.route){
        composable(Routes.Home.route){
            HomePage(){
                navController.navigate(Routes.FoodInfo.route)
            }
        }
        composable(
            Routes.FoodInfo.route
        ){
            FoodInfo()
        }
    }
}