package io.spacecowboyapps.pugs.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.spacecowboyapps.pugs.PugsApplication
import io.spacecowboyapps.pugs.di.component.ActivityComponent
import io.spacecowboyapps.pugs.di.component.DaggerActivityComponent
import io.spacecowboyapps.pugs.ui.main.MainActivity

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        initDagger()
        super.onCreate(savedInstanceState)
    }

    private fun initDagger() {
        activityComponent = DaggerActivityComponent
            .builder()
            .applicationComponent((application as PugsApplication).getComponent())
            .build()

        injectActivity(activityComponent)
    }

    abstract fun injectActivity(component: ActivityComponent)
}