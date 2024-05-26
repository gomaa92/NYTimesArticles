package com.gomaa.domain.di

import com.gomaa.data.repository.PopularArticlesRepositoryImpl
import com.gomaa.data.repository.PopularArticlesRepository
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