package com.maximapps.kmmapp.android.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.maximapps.kmmapp.android.AppTheme
import com.maximapps.kmmapp.android.views.PostItem

@Composable
fun MainScreen(viewModel: PostsViewModel) {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                viewModel.posts.collectAsState().value.forEach { post -> item { PostItem(post) } }
            }
        }
    }
}