package it.cron.githubusers.entity

interface RepositoryApiInterface {
    suspend fun getUsers(since: Int): List<UsersInterface>
    suspend fun getPerson(login: String): Person?
}