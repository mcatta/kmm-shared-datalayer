package dev.marcocattaneo.kmmapp.data

import dev.marcocattaneo.kmmapp.data.client.SharedHttpClient
import dev.marcocattaneo.kmmapp.data.mappers.RepositoryMapper
import dev.marcocattaneo.kmmapp.data.models.Repository
import dev.marcocattaneo.kmmapp.domain.GithubRepository
import dev.marcocattaneo.kmmapp.domain.models.RepositoryApiModel

class GithubApiSource(
    private val httpClient: SharedHttpClient,
    private val repositoryMapper: RepositoryMapper
) : GithubRepository {

    @Throws(Throwable::class)
    override suspend fun getRepositoriesByName(name: String): List<Repository> =
        httpClient.get<List<RepositoryApiModel>>("https://api.github.com/users/$name/repos")
            .map { repositoryMapper.parseFromTo(it) }

}