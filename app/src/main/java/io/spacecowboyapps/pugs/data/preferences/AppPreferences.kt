package io.spacecowboyapps.pugs.data.preferences

import android.content.Context
import android.preference.PreferenceManager.getDefaultSharedPreferences
import io.spacecowboyapps.pugs.di.ApplicationContext
import javax.inject.Inject

class AppPreferences
@Inject constructor(
    @ApplicationContext context: Context) : Preferences {

    private val preferences by lazy { getDefaultSharedPreferences(context) }

    override fun getLastUpdate(): Long =
        preferences.getLong(LAST_UPDATE, 0)


    override fun putLastUpdate(timestamp: Long) =
        preferences.edit().putLong(LAST_UPDATE, timestamp).apply()


    private companion object {
        const val LAST_UPDATE = "LAST_UPDATE"
    }
}