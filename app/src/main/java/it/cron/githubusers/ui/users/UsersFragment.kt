package it.cron.githubusers.ui.users

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import it.cron.githubusers.App
import it.cron.githubusers.R
import it.cron.githubusers.databinding.FragmenUsersBinding
import it.cron.githubusers.ui.users.recycler.UsersPagerAdapter
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class UsersFragment @Inject constructor() : Fragment() {

    private lateinit var binding: FragmenUsersBinding

    private val viewModel: UsersViewModel by viewModels<UsersViewModel> {
        (requireContext().applicationContext as App).appComponent.provideUsersViewModelFactory()
    }

    private lateinit var usersPagerAdapter: UsersPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmenUsersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.layoutManager =
            LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

        usersPagerAdapter = UsersPagerAdapter { login ->
            if (login != null) {
                val bundle = Bundle()
                bundle.putString("login", login)

                findNavController().navigate(
                    R.id.action_users_to_personFragment2,
                    args = bundle
                )
            }
        }



        usersPagerAdapter.addLoadStateListener {
            if (it.refresh is LoadState.Error) {
                var error = (it.refresh as LoadState.Error).error.message
                if (error != null)
                    if (error.contains("403"))
                        error = "Закончился лимит  " + error
                //Log.d("Nik", "${error}")
                Snackbar.make(binding.textView2, "$error", Snackbar.LENGTH_LONG).show()
            }
        }

        loadData()



        binding.swipe.setOnRefreshListener {
            if (job != null)
                job?.cancel()

            lifecycleScope.launch {
                //для красоты задержка
                delay(1000)
                viewModel.getUsers().collect {
                    loadData()
                    binding.swipe.isRefreshing = false
                }
            }
        }
    }

    private var job: Job? = null

    private fun loadData() {
        binding.recycler.adapter = usersPagerAdapter
        job = lifecycleScope.launch {
            viewModel.getUsers().collect {
                usersPagerAdapter.submitData(it)
            }
        }
    }
}