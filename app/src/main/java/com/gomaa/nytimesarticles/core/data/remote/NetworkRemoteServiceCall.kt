package com.gomaa.nytimesarticles.core.data.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

interface NetworkRemoteServiceCall {

    /**
     * safeRemoteCall
     * @param apiCall as suspend fn to call api
     * pass suspend api fn as parameter to safeRemoteCall fn
     * invoke Api at IO thread and handle logic
     * @return Resource< T>  hase success state data and failure state data
     */
    suspend fun <T> safeRemoteCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                // invoke suspend service method
                val response = apiCall.invoke()
                Resource.Success(response)
            } catch (throwable: Exception) {
                // check why the api calls failed?
                Timber.e("Api failed due to exception  --> $throwable")
                throwable.fromExceptionToRemoteError()
            }
        }
    }

    private fun <T> Exception.fromExceptionToRemoteError() = when (this) {
        is IOException -> Resource.Error<T>(RemoteError.ConnectionError, code = -1)
        is HttpException -> {
            Resource.Error(
                RemoteError.ServerError(
                    response()?.errorBody()?.string(), code()
                ),
                code = code(),
            )
        }

        else -> {
            Resource.Error(RemoteError.GeneralError, code = -1)
        }
    }
}
