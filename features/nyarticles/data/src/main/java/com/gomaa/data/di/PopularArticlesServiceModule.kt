package com.gomaa.data.di

import com.gomaa.data.service.MostPopularArticlesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PopularArticlesServiceModule {
    @Provides
    @Singleton
    fun provideArticlesService(retrofit: Retrofit): MostPopularArticlesService =
        retrofit.create(MostPopularArticlesService::class.java)

}