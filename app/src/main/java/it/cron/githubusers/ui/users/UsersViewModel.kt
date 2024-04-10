package it.cron.githubusers.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import it.cron.githubusers.common.ApiUseCaseInterface
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val apiUseCase: ApiUseCaseInterface
) : ViewModel() {

    fun getUsers() = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { apiUseCase.getUsers }
    ).flow.cachedIn(viewModelScope)

}