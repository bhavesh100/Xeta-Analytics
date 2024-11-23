package com.bhavesh.xetaanalyticsassignment.repository

import com.bhavesh.xetaanalyticsassignment.remote.RetrofitClient
import com.bhavesh.xetaanalyticsassignment.remote.dto.FoodApiDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    suspend fun getFoodApiDto(onResult: (FoodApiDto?) -> Unit) {
            RetrofitClient.api.getdata().enqueue(object: Callback<FoodApiDto>{
                override fun onResponse(call: Call<FoodApiDto>, response: Response<FoodApiDto>) {
                    onResult(response.body())
                }

                override fun onFailure(call: Call<FoodApiDto>, t: Throwable) {
                    onResult(null)
                }
            } )
    }
}