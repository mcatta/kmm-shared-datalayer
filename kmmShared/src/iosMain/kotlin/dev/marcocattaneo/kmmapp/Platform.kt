package dev.marcocattaneo.kmmapp

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}


actual class ClientEngine {
    actual val clientEngine: HttpClientEngineFactory<HttpClientEngineConfig> = Ios
}