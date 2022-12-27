package com.maximapps.kmmapp

import kotlinx.coroutines.Dispatchers

actual fun requireDispatcherProvider() = DispatcherProvider { Dispatchers.Default }