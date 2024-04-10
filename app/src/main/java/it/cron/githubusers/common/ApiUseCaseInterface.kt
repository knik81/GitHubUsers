package it.cron.githubusers.common

import androidx.paging.PagingSource
import it.cron.githubusers.entity.PersonInterface
import it.cron.githubusers.entity.UsersInterface

interface ApiUseCaseInterface {
    val getUsers: PagingSource<Int, UsersInterface>
    suspend fun getPerson(login: String): PersonInterface?
}