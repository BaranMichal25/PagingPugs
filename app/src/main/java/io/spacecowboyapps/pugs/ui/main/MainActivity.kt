package io.spacecowboyapps.pugs.ui.main

import android.os.Bundle
import io.spacecowboyapps.pugs.R
import io.spacecowboyapps.pugs.di.component.ActivityComponent
import io.spacecowboyapps.pugs.ui.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun injectActivity(component: ActivityComponent) {
        component.inject(this)
    }
}