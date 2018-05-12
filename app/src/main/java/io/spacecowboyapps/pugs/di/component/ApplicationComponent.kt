package io.spacecowboyapps.pugs.di.component

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Component
import io.spacecowboyapps.pugs.PugsApplication
import io.spacecowboyapps.pugs.data.Repository
import io.spacecowboyapps.pugs.data.db.Database
import io.spacecowboyapps.pugs.di.ApplicationContext
import io.spacecowboyapps.pugs.di.module.ApplicationModule
import io.spacecowboyapps.pugs.di.module.DataModule
import io.spacecowboyapps.pugs.di.module.DatabaseModule
import io.spacecowboyapps.pugs.di.module.NetworkModule
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class])
interface ApplicationComponent {

    fun inject(application: PugsApplication)

    @ApplicationContext
    fun context(): Context

    fun picasso(): Picasso

    fun database(): Database

    fun repository(): Repository
}