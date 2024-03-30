package it.cron.githubusers.ui.person

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import it.cron.githubusers.App
import it.cron.githubusers.databinding.FragmenPersonBinding
import kotlinx.coroutines.launch

class PersonFragment : Fragment() {

    private lateinit var binding: FragmenPersonBinding

    private val viewModel: PersonViewModel by viewModels<PersonViewModel> {
        (requireContext().applicationContext as App).appComponent.providePersonViewModelFactory()
    }


    private var login: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            login = it.getString("login")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmenPersonBinding.inflate(inflater)
        //Log.d("Nik","$login")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (login != null)
            viewModel.getPerson(login!!)

        lifecycleScope.launch {
            viewModel.personStateFlow.collect { person ->
                if (person != null) {
                    binding.imageViewAvatar.load(person.avatar_url)
                    binding.textViewCreatedAt.text = person.created_at
                    binding.textViewEmail.text = person.email
                    binding.textViewName.text = person.name
                    if (person.company != null)
                        binding.textViewOrganization.text = person.company
                    else {
                        binding.textViewOrganization.visibility = View.GONE
                        binding.labelOrganization.visibility = View.GONE
                    }
                    binding.textViewFollowersCount.text = person.followers.toString()
                    binding.textViewFollowingCount.text = person.following.toString()
                }
            }
        }


        binding.imageViewBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}

