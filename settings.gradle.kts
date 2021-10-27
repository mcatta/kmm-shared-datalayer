pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()

        maven("https://jitpack.io")
    }
}

rootProject.name = "KmmApp"
include(":kmmAndroidApp")
include(":kmmShared")