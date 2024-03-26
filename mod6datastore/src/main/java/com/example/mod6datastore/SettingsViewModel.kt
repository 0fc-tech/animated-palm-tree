package com.example.mod6datastore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SettingsViewModel(
    val repository: UserPreferencesRepository) : ViewModel() {
    val primaryColor : Flow<String?> = repository.primaryColor

    fun savePrimaryColor(color: String) {
        viewModelScope.launch {
            repository.savePrimaryColor(color)
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = object :
            ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T { val application =
                    checkNotNull(
                        extras[
                            ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY
                        ])
                return SettingsViewModel(
                    UserPreferencesRepository(
                        application.applicationContext
                    ),
                ) as T
            }
        }
    }


}