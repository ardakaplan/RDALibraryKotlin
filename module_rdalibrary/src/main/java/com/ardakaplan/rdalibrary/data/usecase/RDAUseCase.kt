package com.ardakaplan.rdalibrary.data.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.ardakaplan.rdalogger.RDALogger
import kotlinx.coroutines.CoroutineScope

abstract class RDAUseCase<in P, R> {

    suspend operator fun invoke(parameter: P, callback: MutableLiveData<RDAUseCaseResult<R>>) {
        callback.postValue(RDAUseCaseResult.Loading)
        try {
            callback.postValue(RDAUseCaseResult.Success(execute(parameter)))
        } catch (e: Exception) {
            callback.postValue(handleError(e))
        }
    }

//    operator fun invoke(
//        coroutineScope: CoroutineScope,
//        parameter: P
//    ): LiveData<RDAUseCaseResult<R>> = liveData(coroutineScope.coroutineContext) {
//        emit(RDAUseCaseResult.Loading)
//        try {
//            emit(RDAUseCaseResult.Success(execute(parameter)))
//        } catch (e: Exception) {
//            emit(handleError(e))
//        }
//    }

    open suspend operator fun invoke(parameter: P): R {
        return execute(parameter)
    }

    open fun handleError(e: Exception): RDAUseCaseResult<R> {
        return RDAUseCaseResult.Error(e)
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameter: P): R
}

suspend operator fun <R> RDAUseCase<Unit, R>.invoke(result: MutableLiveData<RDAUseCaseResult<R>>) =
    this(Unit, result)