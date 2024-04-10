package it.cron.githubusers.common

import it.cron.githubusers.entity.Person
import it.cron.githubusers.entity.UsersInterface

interface RepositoryApiInterface {
    suspend fun getUsers(since: Int): List<UsersInterface>
    suspend fun getPerson(login: String): Person?
}