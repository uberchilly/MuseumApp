package com.elfak.museumapp.model

sealed class AsyncTaskState {

    object InitialState : AsyncTaskState()

    object LoadingState : AsyncTaskState()

    data class ErrorState(val error: Throwable) : AsyncTaskState()

    data class SuccessState<T>(val data: T) : AsyncTaskState()
}
