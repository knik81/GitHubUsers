package it.cron.githubusers.entity

data class Users(
    override val login: String,
    override val id: Int,
    override val avatar_url: String
) : UsersInterface
