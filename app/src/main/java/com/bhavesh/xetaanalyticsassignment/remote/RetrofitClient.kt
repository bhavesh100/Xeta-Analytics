package com.bhavesh.xetaanalyticsassignment.remote

import com.bhavesh.xetaanalyticsassignment.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val api: XetaApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(XetaApi::class.java)
    }
}