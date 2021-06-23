package dev.marcocattaneo.kmmapp.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcocattaneo.kmmapp.data.GithubApiSource
import dev.marcocattaneo.kmmapp.data.client.SharedHttpClient
import dev.marcocattaneo.kmmapp.data.mappers.RepositoryMapper
import dev.marcocattaneo.kmmapp.domain.GithubRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideGithubRepository(): GithubRepository = GithubApiSource(SharedHttpClient(), RepositoryMapper())

}