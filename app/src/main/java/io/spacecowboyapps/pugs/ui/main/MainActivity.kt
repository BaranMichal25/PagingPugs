package io.spacecowboyapps.pugs.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.spacecowboyapps.pugs.R
import io.spacecowboyapps.pugs.data.Repository
import io.spacecowboyapps.pugs.data.db.Database
import io.spacecowboyapps.pugs.data.db.Pug
import io.spacecowboyapps.pugs.di.component.ActivityComponent
import io.spacecowboyapps.pugs.ui.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var database: Database

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repository.getPugs().observe(this, Observer {   // TODO ViewModel
            println(it)
        })
    }

    override fun injectActivity(component: ActivityComponent) {
        component.inject(this)
    }
}
