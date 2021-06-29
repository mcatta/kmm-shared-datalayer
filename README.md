# KMM shared datalayer with Kotlin Multiplatform
[![CI](https://github.com/mcatta/kmm-shared-datalayer/actions/workflows/blank.yml/badge.svg)](https://github.com/mcatta/kmm-shared-datalayer/actions/workflows/blank.yml)

This is a sample application that uses a shared data layer written in __kotlin multiplatform__.

#### For the data/domain layer part I'm using:
* Ktor for the HttpClient layer (with a ClientEngine delegated to the single native module)
* Kotlin-serialization for the serialization (this avoids the use of a specific platform library like Gson or Moshi for Android)

#### For the presentation layer:
* Dagger Hilt for DI
* ViewModel/Lifecye stuffs for the android business logic

#### TODO:
* a draft implementation of the data layer on iOS
