package it.cron.githubusers.data.api

import it.cron.githubusers.entity.Person
import it.cron.githubusers.entity.Users
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("/users")
    suspend fun getUsers(
        @Query("since") since: Int
    ): List<Users>


    @GET("/users/{path}")
    suspend fun getPerson(
        @Path("path") login: String
    ): Person
}
