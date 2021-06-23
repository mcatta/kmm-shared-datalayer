package dev.marcocattaneo.kmmapp.data

import dev.marcocattaneo.kmmapp.data.client.SharedHttpClient
import dev.marcocattaneo.kmmapp.domain.GithubRepository
import dev.marcocattaneo.kmmapp.domain.models.Repository

class ApiDatasource(
    private val httpClient: SharedHttpClient
) : GithubRepository {

    override suspend fun getRepositoriesByName(name: String): List<Repository> = httpClient.get("https://api.github.com/users/$name/repos")

}