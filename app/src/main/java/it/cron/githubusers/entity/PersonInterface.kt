package it.cron.githubusers.entity

interface PersonInterface {
    val name: String?
    val avatar_url: String?
    val email:String?
    val company: String?
    val followers: Int?
    val following: Int?
    var created_at: String?


}