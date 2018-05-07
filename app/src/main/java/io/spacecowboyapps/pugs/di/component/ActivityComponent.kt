package io.spacecowboyapps.pugs.di.component

import dagger.Component
import io.spacecowboyapps.pugs.ui.main.MainActivity
import io.spacecowboyapps.pugs.di.PerActivity
import io.spacecowboyapps.pugs.di.module.ActivityModule

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}