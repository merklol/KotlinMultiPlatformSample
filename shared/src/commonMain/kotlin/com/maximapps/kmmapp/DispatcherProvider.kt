package com.maximapps.kmmapp

import kotlinx.coroutines.CoroutineDispatcher

fun interface DispatcherProvider {
    fun get(): CoroutineDispatcher
}

expect fun requireDispatcherProvider(): DispatcherProvider