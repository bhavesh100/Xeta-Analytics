package com.bhavesh.xetaanalyticsassignment.remote

import com.bhavesh.xetaanalyticsassignment.remote.dto.FoodApiDto
import retrofit2.Call
import retrofit2.http.GET

interface XetaApi {
    @GET("food_info/")
    suspend fun getdata(): Call<FoodApiDto>
}