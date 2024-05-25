package com.gomaa.nyarticles.di

import com.gomaa.nyarticles.data.repository.PopularArticlesRepositoryImpl
import com.gomaa.nyarticles.domain.repository.PopularArticlesRepository
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