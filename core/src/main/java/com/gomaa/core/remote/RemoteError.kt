package com.gomaa.core.remote

sealed class RemoteError {
    data object ConnectionError : RemoteError()
    data object GeneralError : RemoteError()
    data class ServerError(val errorBody: String?, val errorCode: Int) : RemoteError()
}
