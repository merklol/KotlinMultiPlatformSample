package com.maximapps.kmmapp.android.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.maximapps.kmmapp.TypicodeApi
import com.maximapps.kmmapp.Post
import com.maximapps.kmmapp.android.common.MutablePublishFlow
import com.maximapps.kmmapp.android.common.extensions.safeLaunch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    private val api: TypicodeApi
) : ViewModel() {
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts = _posts.asStateFlow()

    private val _error = MutablePublishFlow<Throwable>()
    val error = _error.asSharedFlow()

    fun loadPosts(firstCall: Boolean) {
        if (firstCall) {
            viewModelScope.safeLaunch({ _posts.tryEmit(api.loadPosts()) }, _error::tryEmit)
        }
    }

    @Suppress("unchecked_cast")
    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(TypicodeApi()) as T
        }
    }
}