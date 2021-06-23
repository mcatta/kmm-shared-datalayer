package dev.marcocattaneo.kmmapp.domain.mappers

interface IMapper<From, To> {

    fun parseFromTo(from: From): To

    fun parseToFrom(to: To): From

}