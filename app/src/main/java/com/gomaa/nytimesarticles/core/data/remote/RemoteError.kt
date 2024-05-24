package com.gomaa.nytimesarticles.core.data.remote

import com.gomaa.nytimesarticles.R

sealed class RemoteError {
    data object ConnectionError : RemoteError()
    data object GeneralError : RemoteError()
    data class ServerError(val errorBody: String?, val errorCode: Int) : RemoteError()
}

fun RemoteError.toMessageId() = when (this) {
    RemoteError.ConnectionError -> R.string.no_internet_connection
    is RemoteError.ServerError -> R.string.server_error
    else -> R.string.something_went_wrong

}
