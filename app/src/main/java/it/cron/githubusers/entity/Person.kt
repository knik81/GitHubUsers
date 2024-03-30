package it.cron.githubusers.entity

data class Person(
    override val name: String?,
    override val avatar_url: String?,
    override val email: String?,
    override val company: String?,
    override val followers: Int?,
    override val following: Int?,
    override var created_at: String?
):PersonInterface
