package com.example.mod8workmanager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay

class SyncDataWorker(appContext : Context,
                     workerParameters: WorkerParameters)
    : CoroutineWorker(appContext,workerParameters) {
    override suspend fun doWork(): Result {
        return try{
            delay(20000)
            Result.success()
        }catch (e: CancellationException){
            Result.failure()
        }
    }

}