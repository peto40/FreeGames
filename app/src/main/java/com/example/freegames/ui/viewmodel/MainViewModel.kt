package com.example.freegames.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freegames.data.repository.RepositoryImpl
import com.example.freegames.domain.model.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val repository: RepositoryImpl
): ViewModel() {

    private val _pcGameState: MutableStateFlow<Resource<List<Game>>> =
            MutableStateFlow(value = Resource.Waiting())
    val pcGameState: StateFlow<Resource<List<Game>>>
        get() = _pcGameState

    private val _browseGamesState: MutableStateFlow<Resource<List<Game>>> =
            MutableStateFlow(value = Resource.Waiting())
    val browseGamesState: StateFlow<Resource<List<Game>>>
        get() = _browseGamesState

    fun getPcShooters() {
        viewModelScope.launch(Dispatchers.Main) {
            _pcGameState.value = repository.getPcShooters()
        }
    }
    fun getBrowserRpg() {
        viewModelScope.launch(Dispatchers.Main) {
            _browseGamesState.value = repository.getBrowserRpg()
        }
    }
}