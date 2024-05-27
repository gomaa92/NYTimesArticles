package com.gomaa.core.remote

sealed class Resource<T>(
    val _data: T? = null,
    val _remoteError: RemoteError? = null,
) {
    data class Success<T>(val data: T) : Resource<T>(data)
    data class Error<T>(val remoteError: RemoteError, val data: T? = null, val code: Int) :
        Resource<T>(data, remoteError)
}
