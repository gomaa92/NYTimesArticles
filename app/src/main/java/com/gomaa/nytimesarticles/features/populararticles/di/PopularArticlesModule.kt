package com.gomaa.nytimesarticles.features.populararticles.di

import com.gomaa.nytimesarticles.features.populararticles.data.repository.PopularArticlesRepositoryImpl
import com.gomaa.nytimesarticles.features.populararticles.domain.repository.PopularArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class PopularArticlesModule {
    @Binds
    abstract fun bindRepository(
        repository: PopularArticlesRepositoryImpl
    ): PopularArticlesRepository

}