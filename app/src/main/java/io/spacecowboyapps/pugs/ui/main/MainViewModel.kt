package io.spacecowboyapps.pugs.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import io.spacecowboyapps.pugs.data.Repository
import io.spacecowboyapps.pugs.data.db.Pug

class MainViewModel(repository: Repository) : ViewModel() {

    val pugsList: LiveData<PagedList<Pug>> = repository.getPugs()
}