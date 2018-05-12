package io.spacecowboyapps.pugs.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import io.spacecowboyapps.pugs.R
import io.spacecowboyapps.pugs.data.Repository
import io.spacecowboyapps.pugs.di.component.ActivityComponent
import io.spacecowboyapps.pugs.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository.getPugs().observe(this, Observer { // TODO ViewModel
            adapter.submitList(it)
        })

        recyclerView_main.adapter = adapter
    }

    override fun injectActivity(component: ActivityComponent) {
        component.inject(this)
    }
}
