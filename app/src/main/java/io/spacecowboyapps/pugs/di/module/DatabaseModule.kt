package io.spacecowboyapps.pugs.di.module

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.spacecowboyapps.pugs.data.db.Database
import io.spacecowboyapps.pugs.data.db.Database.Companion.DATABASE_NAME
import io.spacecowboyapps.pugs.di.ApplicationContext
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Provides
    @Reusable
    fun provideDatabase(@ApplicationContext context: Context): Database =
        Room.databaseBuilder(context, Database::class.java, DATABASE_NAME).build()
}