package com.example.freegames.data.repository

import com.example.freegames.data.remote.api.Api
import com.example.freegames.domain.model.Game
import com.example.freegames.domain.repository.Repository
import com.example.freegames.ui.viewmodel.Resource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: Api,
) : Repository, BaseRepository() {

    override suspend fun getPcShooters(): Resource<List<Game>> {
        val response = invokeApi {
            api.getPcShooters()
        }

        return when (response) {
            is Resource.Error -> Resource.Error(error = response.error)
            is Resource.Drawback -> Resource.Drawback(
                data = response.data?.map { it.toGame() } ?: emptyList()
            )
            is Resource.Success -> Resource.Success(
                data = response.data?.map { it.toGame() } ?: emptyList()
            )
            is Resource.Waiting -> Resource.Waiting()
        }
    }

    override suspend fun getBrowserRpg(): Resource<List<Game>> {
        val response = invokeApi {
            api.getBrowserRpg()
        }

        return when (response) {
            is Resource.Error -> Resource.Error(error = response.error)
            is Resource.Drawback -> Resource.Drawback(
                data = response.data?.map { it.toGame() } ?: emptyList()
            )
            is Resource.Success -> Resource.Success(
                data = response.data?.map { it.toGame() } ?: emptyList()
            )
            is Resource.Waiting -> Resource.Waiting()
        }
    }
}