package dev.marcocattaneo.kmmapp.android.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcocattaneo.kmmapp.data.models.Repository
import dev.marcocattaneo.kmmapp.domain.GithubRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel() {

    val dataLiveData = MutableLiveData<List<Repository>>()

    fun fetch() {
        viewModelScope.launch {
            try {
                val result = githubRepository.getRepositoriesByName("mcatta")
                dataLiveData.postValue(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}