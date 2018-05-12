package io.spacecowboyapps.pugs.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import io.spacecowboyapps.pugs.R
import io.spacecowboyapps.pugs.di.component.ActivityComponent
import io.spacecowboyapps.pugs.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var factory: MainViewModelFactory

    @Inject
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        viewModel.pugsList.observe(this, Observer {
            adapter.submitList(it)
        })

        recyclerView_main.adapter = adapter
    }

    override fun injectActivity(component: ActivityComponent) {
        component.inject(this)
    }
}
