package it.cron.githubusers.ui.users.recycler

import androidx.recyclerview.widget.DiffUtil
import it.cron.githubusers.entity.UsersInterface

class UsersDiffUtilCallBack: DiffUtil.ItemCallback<UsersInterface>() {
    override fun areItemsTheSame(oldItem: UsersInterface, newItem: UsersInterface): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UsersInterface, newItem: UsersInterface): Boolean {
        return oldItem.id == newItem.id
    }
}