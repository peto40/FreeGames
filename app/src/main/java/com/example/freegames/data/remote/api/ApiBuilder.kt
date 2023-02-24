package com.example.freegames.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

const val API_BASE_URL: String = "https://www.freetogame.com/api/"

class ApiBuilder @Inject constructor() {

    fun <Api> builder(api: Class<Api>): Api {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

}