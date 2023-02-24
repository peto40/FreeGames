package com.example.freegames.di

import com.example.freegames.data.remote.api.Api
import com.example.freegames.data.remote.api.ApiBuilder
import com.example.freegames.data.repository.RepositoryImpl
import com.example.freegames.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesApiService(apiBuilder: ApiBuilder): Api {
        return apiBuilder.builder(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: Api): Repository {
        return RepositoryImpl(api)
    }

}