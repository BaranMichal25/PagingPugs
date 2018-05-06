package io.spacecowboyapps.pugs.di.component

import android.content.Context
import dagger.Component
import io.spacecowboyapps.pugs.PugsApplication
import io.spacecowboyapps.pugs.di.ApplicationContext
import io.spacecowboyapps.pugs.di.module.ApplicationModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun inject(application: PugsApplication)

    @ApplicationContext
    fun context(): Context

}