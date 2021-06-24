package dev.marcocattaneo.kmmapp.domain

import dev.marcocattaneo.kmmapp.data.models.Repository

interface GithubRepository {

    @Throws(Throwable::class)
    suspend fun getRepositoriesByName(name: String): List<Repository>

}