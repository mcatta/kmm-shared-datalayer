package dev.marcocattaneo.kmmapp.data.mappers

import dev.marcocattaneo.kmmapp.data.models.Repository
import dev.marcocattaneo.kmmapp.domain.mappers.IMapper
import dev.marcocattaneo.kmmapp.domain.models.RepositoryApiModel

class RepositoryMapper: IMapper<RepositoryApiModel, Repository> {

    override fun parseFromTo(from: RepositoryApiModel) = Repository(
        id = from.id,
        name = from.full_name
    )

    override fun parseToFrom(to: Repository) = RepositoryApiModel(
        id = to.id,
        full_name = to.name
    )
}