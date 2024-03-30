package it.cron.githubusers.di

import dagger.Module
import dagger.Provides
import it.cron.githubusers.data.RepositoryApi
import it.cron.githubusers.domain.ApiUseCase
import it.cron.githubusers.entity.RepositoryApiInterface
import it.cron.githubusers.entity.ApiUseCaseInterface

@Module
object ModuleApp {

    @Provides
    fun provideApiRepositoryInterface(repositoryApi: RepositoryApi): RepositoryApiInterface {
        return repositoryApi
    }

    @Provides
    fun provideApiUseCaseInterface(apiUseCase: ApiUseCase): ApiUseCaseInterface {
        return apiUseCase
    }
}