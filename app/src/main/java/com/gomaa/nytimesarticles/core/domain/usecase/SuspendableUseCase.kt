package com.gomaa.nytimesarticles.core.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SuspendableUseCase<I, R> {
    suspend fun execute(input: I): Flow<R>
}
