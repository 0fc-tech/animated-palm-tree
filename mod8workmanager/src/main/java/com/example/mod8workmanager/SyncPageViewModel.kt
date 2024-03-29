package com.example.mod8workmanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.time.Duration

class SyncPageViewModel(val workManager: WorkManager) : ViewModel() {
    init {
        //Contraintes wifi à appliqueer à la requête, permettant de ne pas
        //lancer la tâche tant que pas de Wifi
        val constraintsWifi = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .build()
        val syncWorkRequest = OneTimeWorkRequest.Builder(SyncDataWorker::class.java)
            .setConstraints(constraintsWifi)
            .build()

        val recurrentWorkRequest = PeriodicWorkRequest.Builder(
                            SyncDataWorker::class.java,
                            Duration.ofMinutes(15))
            .setConstraints(constraintsWifi)
            .build()

        //workManager.enqueue(syncWorkRequest)
        workManager.enqueue(recurrentWorkRequest)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return SyncPageViewModel(
                    WorkManager.getInstance(application.applicationContext)
                ) as T
            }
        }
    }

}