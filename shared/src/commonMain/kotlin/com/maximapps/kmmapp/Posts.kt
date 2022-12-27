package com.maximapps.kmmapp

import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Serializable
@Resource("/posts")
class Posts