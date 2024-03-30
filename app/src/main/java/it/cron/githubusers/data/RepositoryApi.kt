package it.cron.githubusers.data

import android.util.Log
import it.cron.githubusers.data.api.RetrofitApi
import it.cron.githubusers.entity.Person
import it.cron.githubusers.entity.RepositoryApiInterface
import javax.inject.Inject

class RepositoryApi @Inject constructor() : RepositoryApiInterface {

    override suspend fun getUsers(since: Int) = RetrofitApi.api.getUsers(since)

    override suspend fun getPerson(login: String): Person? {
        return try {
            RetrofitApi.api.getPerson(login)
        } catch (e: Exception) {
            Log.d("Nik", "Ошибка RepositoryApi: $e")
            null
        }
    }

}