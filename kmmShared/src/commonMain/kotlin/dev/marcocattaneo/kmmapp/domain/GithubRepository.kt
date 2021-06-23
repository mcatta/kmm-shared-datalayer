package dev.marcocattaneo.kmmapp.domain

import dev.marcocattaneo.kmmapp.domain.models.Repository

interface GithubRepository {

    suspend fun getRepositoriesByName(name: String): List<Repository>

}