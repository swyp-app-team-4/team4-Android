package com.example.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val APP_CONFIG_NAME = "swift_app_config.pb"
private val Context.appDataStore: DataStore<Preferences> by preferencesDataStore(name = APP_CONFIG_NAME)

@Singleton
class AppManageDataStore @Inject constructor(
    @ApplicationContext context: Context
) {
    private val appDataStore = context.appDataStore
}