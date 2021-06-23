package dev.marcocattaneo.kmmapp.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Repository(
    val id: Long,
    val full_name: String
)