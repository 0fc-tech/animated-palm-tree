package com.example.mod6datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(private val context: Context) {
    //Paramètre d'extension "dataStore" sur le contexte
    //Me permet de récupérer l'instance de dataStore
    // sur une instance Context
    private val Context.dataStore by preferencesDataStore(
        name = "user_preferences")

    suspend fun savePrimaryColor(color: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_PRIMARY_COLOR] = color
        }
    }
    // Lire la couleur primaire
    val primaryColor: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[KEY_PRIMARY_COLOR]
        }


    companion object {
        enum class ValNotif{
           VAL_NOTIF_MARKETING,VAL_NOTIF_FOLLOWERS,
            VAL_NOTIF_LIKED_POSTS }
        private val KEY_PRIMARY_COLOR =
            stringPreferencesKey("primary_color")
        private val KEY_DARK_MODE =
            booleanPreferencesKey("dark_mode")
        private val KEY_NOTIFICATION_MARKETING =
            booleanPreferencesKey("KEY_NOTIFICATION_MARKETING")
        private val KEY_NOTIFICATION_FOLLOWERS =
            booleanPreferencesKey("KEY_NOTIFICATION_FOLLOWERS")
        private val KEY_NOTIFICATION_LIKED_POSTS =
            booleanPreferencesKey("KEY_NOTIFICATION_LIKED_POSTS")
    }

}