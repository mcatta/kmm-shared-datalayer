package dev.marcocattaneo.kmmapp

import io.ktor.client.engine.*
import io.ktor.client.engine.android.*

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual class ClientEngine {
    actual val clientEngine: HttpClientEngine = Android.create()
}