package it.cron.githubusers

import android.app.Application
import it.cron.githubusers.di.AppComponent
import it.cron.githubusers.di.DaggerAppComponent


class App: Application() {
    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .build()
    }








}