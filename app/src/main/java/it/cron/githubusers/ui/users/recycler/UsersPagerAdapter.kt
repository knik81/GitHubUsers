package it.cron.githubusers.ui.users.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import coil.load
import it.cron.githubusers.databinding.CustomRecyclerElementBinding
import it.cron.githubusers.entity.UsersInterface

class UsersPagerAdapter(
    private val click: (String?) -> Unit
) : PagingDataAdapter<UsersInterface, UsersViewHolder>(UsersDiffUtilCallBack()) {


    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {

        holder.binding.imageView.load(getItem(position)?.avatar_url)
        holder.binding.textViewLogin.text = getItem(position)?.login
        holder.binding.textViewId.text = getItem(position)?.id.toString()

        holder.binding.imageView.setOnClickListener {
            click(getItem(position)?.login)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding =
            CustomRecyclerElementBinding.inflate(LayoutInflater.from(parent.context))

        return UsersViewHolder(binding)
    }
}