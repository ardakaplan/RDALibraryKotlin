package com.ardakaplan.rdalibrary.data.usecase

sealed class RDAUseCaseResult<out R> {

    data class Success<out T>(val data : T) : RDAUseCaseResult<T>()
    data class Error(val exception : Exception) : RDAUseCaseResult<Nothing>()
    object Loading : RDAUseCaseResult<Nothing>()

    override fun toString() : String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

val RDAUseCaseResult<*>.succeeded
    get() = this is RDAUseCaseResult.Success && data != null

fun <T> RDAUseCaseResult<T>.successOr(fallback : T) : T {
    return (this as? RDAUseCaseResult.Success<T>)?.data ?: fallback
}

fun <T> RDAUseCaseResult<T>.ifSuccess(op : ((T) -> Unit)) {

    if (this is RDAUseCaseResult.Success) {

        op(this.data)
    }
}

fun <T> RDAUseCaseResult<T>.ifLoading(op : () -> Unit) {

    if (this is RDAUseCaseResult.Loading) {

        op()
    }
}

fun RDAUseCaseResult<Any>.ifResponded(op : () -> Unit) {

    if (this is RDAUseCaseResult.Error || this is RDAUseCaseResult.Success) {

        op()
    }
}

fun RDAUseCaseResult<Any>.ifError(op : ((e : Exception) -> Unit)) {

    if (this is RDAUseCaseResult.Error) {

        op(this.exception)
    }
}

