package io.spacecowboyapps.pugs

import android.app.Application
import io.spacecowboyapps.pugs.di.component.ApplicationComponent
import io.spacecowboyapps.pugs.di.component.DaggerApplicationComponent
import io.spacecowboyapps.pugs.di.module.ApplicationModule

class PugsApplication : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        applicationComponent =
                DaggerApplicationComponent
                    .builder()
                    .applicationModule(ApplicationModule(this))
                    .build()
        applicationComponent.inject(this)
    }

    fun getComponent() = applicationComponent
}