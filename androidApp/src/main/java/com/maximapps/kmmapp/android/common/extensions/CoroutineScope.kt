package com.maximapps.kmmapp.android.common.extensions

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

inline fun CoroutineScope.safeLaunch(
    crossinline action: suspend () -> Unit,
    crossinline onError: suspend (Throwable) -> Unit,
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    errorDispatcher: CoroutineDispatcher = Dispatchers.Main
): Job {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        launch(errorDispatcher) {
            onError(throwable)
        }
    }
    return launch(exceptionHandler + dispatcher) { action() }
}