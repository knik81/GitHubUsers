package it.cron.githubusers.entity

import androidx.paging.PagingSource

interface ApiUseCaseInterface {
    val getUsers: PagingSource<Int, UsersInterface>
    suspend fun getPerson(login: String): PersonInterface?
}