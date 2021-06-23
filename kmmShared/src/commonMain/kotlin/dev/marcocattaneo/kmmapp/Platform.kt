package dev.marcocattaneo.kmmapp

import io.ktor.client.engine.*

expect class Platform() {
    val platform: String
}

expect class ClientEngine() {
    val clientEngine: HttpClientEngineFactory<HttpClientEngineConfig>
}