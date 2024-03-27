package com.example.mod6room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ListMusicViewModel(val dbClient: DatabaseClient) : ViewModel() {
    private val _stateMusicList = MutableStateFlow(emptyList<Music>())
    val stateMusicList = _stateMusicList.asStateFlow()
    init{
        viewModelScope.launch {
            insertMusic(
                Music(0L,"Never Gonna Give You Up","Rick Astley",220)
            )
            insertMusic(
                Music(0L,"Feel Good","Polo & Pan",240)
            )

            fetchMusics()

        }
    }

    fun fetchMusics(){
        //On éxécute dans une coroutine ayant accès au Disque (IO)
        viewModelScope.launch(Dispatchers.IO) {
            //Je récupère le Flow des musiques depuis la BDD Room
            //Puis pour chaque list de musiques récupérée
            dbClient.appDatabase.musicDao().getAllMusic().collect{
                _stateMusicList.value = it
            }
        }
    }
    fun insertMusic(music: Music) : Flow<Long> {
        return flow{
            viewModelScope.launch(Dispatchers.IO) {
                return@launch dbClient.appDatabase.musicDao().insert(music)
            }
        }

    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return ListMusicViewModel(
                    DatabaseClient(application.applicationContext),
                ) as T
            }
        }
    }

}