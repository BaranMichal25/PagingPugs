package io.spacecowboyapps.pugs.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.spacecowboyapps.pugs.di.ApplicationContext


@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = application
}