package com.maximapps.kmmapp

import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Serializable
@Resource("/posts")
data class Post(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)