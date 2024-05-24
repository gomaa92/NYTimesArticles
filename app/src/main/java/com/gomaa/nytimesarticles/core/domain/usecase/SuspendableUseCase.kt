package com.gomaa.nytimesarticles.core.domain.usecase

interface SuspendableUseCase<I, O> {
    suspend fun execute(input: I): O
}
