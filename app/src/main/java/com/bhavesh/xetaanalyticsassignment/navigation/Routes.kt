package com.bhavesh.xetaanalyticsassignment.navigation

sealed class Routes(val route: String) {
    object Home : Routes("home_page")
    object FoodInfo : Routes("food_info")
}