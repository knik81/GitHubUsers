package it.cron.githubusers.domain

import androidx.paging.PagingSource
import it.cron.githubusers.data.api.PagingSourceUser
import it.cron.githubusers.entity.RepositoryApiInterface
import it.cron.githubusers.entity.ApiUseCaseInterface
import it.cron.githubusers.entity.UsersInterface
import javax.inject.Inject

class ApiUseCase @Inject constructor(
    private val repositoryApi: RepositoryApiInterface,
    pagingSourceUser: PagingSourceUser
): ApiUseCaseInterface {
    override val getUsers = pagingSourceUser as PagingSource<Int, UsersInterface>


    override suspend fun getPerson(login: String) = repositoryApi.getPerson(login)
}