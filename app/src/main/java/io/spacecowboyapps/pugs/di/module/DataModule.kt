package io.spacecowboyapps.pugs.di.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.spacecowboyapps.pugs.data.AppRepository
import io.spacecowboyapps.pugs.data.Repository
import io.spacecowboyapps.pugs.data.db.Database
import io.spacecowboyapps.pugs.data.network.AppClient
import io.spacecowboyapps.pugs.data.preferences.Preferences


@Module(includes = [DatabaseModule::class, NetworkModule::class, PreferencesModule::class])
class DataModule {

    @Provides
    @Reusable
    fun provideRepository(client: AppClient, database: Database, preferences: Preferences): Repository =
        AppRepository(client, database, preferences)
}