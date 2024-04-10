package it.cron.githubusers.di

import dagger.Component
import it.cron.githubusers.ui.person.PersonViewModelFactory
import it.cron.githubusers.ui.users.UsersViewModelFactory


@Component(
    modules = [ModuleApp::class]
)

interface AppComponent  {
    fun provideUsersViewModelFactory(): UsersViewModelFactory

    fun providePersonViewModelFactory(): PersonViewModelFactory
}

/*
interface AppComponent2 {


    @Component.Factory
    interface UsersViewModelFactory {
        fun provideUsersViewModelFactory(): UsersViewModelFactory
        fun create(@BindsInstance context: Context): AppComponent
    }

    @Component.Factory
    interface PersonViewModelFactory {
        fun providePersonViewModelFactory(): PersonViewModelFactory
    }


    //fun provideUsersViewModelFactory(): UsersViewModelFactory

    //fun providePersonViewModelFactory(): PersonViewModelFactory


}

 */