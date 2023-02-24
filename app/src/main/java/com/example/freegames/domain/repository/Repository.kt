package com.example.freegames.domain.repository

import com.example.freegames.domain.model.Game
import com.example.freegames.ui.viewmodel.Resource

interface Repository {

    suspend fun getPcShooters(): Resource<List<Game>>

    suspend fun getBrowserRpg(): Resource<List<Game>>
}