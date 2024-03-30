package it.cron.githubusers.ui.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class PersonViewModelFactory @Inject constructor (
    private val personViewModel: PersonViewModel
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return personViewModel as T
    }
}