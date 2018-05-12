package io.spacecowboyapps.pugs.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.spacecowboyapps.pugs.data.preferences.AppPreferences
import io.spacecowboyapps.pugs.data.preferences.Preferences
import io.spacecowboyapps.pugs.di.ApplicationContext


@Module
class PreferencesModule {

    @Provides
    @Reusable
    fun providePreferences(@ApplicationContext context: Context): Preferences =
            AppPreferences(context)
}