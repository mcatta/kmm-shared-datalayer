package dev.marcocattaneo.kmmapp.data.client

import dev.marcocattaneo.kmmapp.ClientEngine
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*

class SharedHttpClient {

    val httpClient = HttpClient(ClientEngine().clientEngine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    suspend inline fun <reified T> get(url: String): T = this.httpClient.get(url)

}