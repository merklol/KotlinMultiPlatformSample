package com.maximapps.kmmapp

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.plugins.resources.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

private const val TypicodeURL = "https://jsonplaceholder.typicode.com"

class TypicodeApi {
    private val client = HttpClient() {
        install(ContentNegotiation) { json(Json { isLenient = true }) }
        install(Resources)
        defaultRequest { url(TypicodeURL) }
    }

    suspend fun loadPosts(): List<Post> = withContext(requireDispatcherProvider().get()) {
        client.get(Posts()).body()
    }
}