package it.cron.githubusers.ui.person

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.cron.githubusers.entity.ApiUseCaseInterface
import it.cron.githubusers.entity.PersonInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject


class PersonViewModel @Inject constructor (
    private val apiUseCase: ApiUseCaseInterface
) : ViewModel() {

    private val _personStateFlow = MutableStateFlow<PersonInterface?>(null)
    val personStateFlow = _personStateFlow.asStateFlow()

    fun getPerson(login: String){
        viewModelScope.launch {
            val person = apiUseCase.getPerson(login)
            val formatter = DateTimeFormatter.ISO_DATE_TIME
            val parsedDate = LocalDate.parse(person?.created_at, formatter)
            Log.d("Nik", "modifiedDate = ${parsedDate}")
            person?.created_at = parsedDate.toString()
            Log.d("Nik", "modifiedDate = ${person?.created_at}")

            _personStateFlow.value = person
        }
    }

}