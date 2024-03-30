package it.cron.githubusers.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


@Suppress("UNCHECKED_CAST")
class UsersViewModelFactory @Inject constructor (
    private val usersViewModel: UsersViewModel
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return usersViewModel as T
    }
}