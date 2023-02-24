package com.example.freegames.data.remote.api

import com.example.freegames.data.remote.dto.GameDto
import retrofit2.http.GET

interface Api {

    @GET("games?platform=pc&category=shooter")
    suspend fun getPcShooters(): List<GameDto>

    @GET("games?platform=browser&category=mmorpg")
    suspend fun getBrowserRpg(): List<GameDto>


}