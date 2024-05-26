package com.gomaa.core.usecase

interface SuspendableUseCase<I, O> {
    suspend fun execute(input: I): O
}
