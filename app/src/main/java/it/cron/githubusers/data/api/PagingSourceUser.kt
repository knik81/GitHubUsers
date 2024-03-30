package it.cron.githubusers.data.api

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import it.cron.githubusers.data.RepositoryApi
import it.cron.githubusers.entity.Users
import javax.inject.Inject

class PagingSourceUser @Inject constructor(
    private val repositoryApi: RepositoryApi
) : PagingSource<Int, Users>() {
    override fun getRefreshKey(state: PagingState<Int, Users>): Int? {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Users>{
        val since = params.key ?: 0

        return try {
            val resultUsers = repositoryApi.getUsers(since)
            val lastId = resultUsers.last().id

            LoadResult.Page(
                data = resultUsers,
                prevKey = null,
                nextKey = if (resultUsers.isEmpty()) null else since + lastId
            )
        } catch (e: Exception) {
            Log.d("Nik","ошибка: PagingSourceUser $e")
            LoadResult.Error(e)
        }

    }
}