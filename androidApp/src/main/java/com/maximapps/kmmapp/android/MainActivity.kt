package com.maximapps.kmmapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.maximapps.kmmapp.android.screens.MainScreen
import com.maximapps.kmmapp.android.screens.MainViewModel

class MainActivity : ComponentActivity() {
    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this, MainViewModel.Factory())[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadPosts(savedInstanceState == null)
        setContent {
            MainScreen(viewModel)
        }
    }
}