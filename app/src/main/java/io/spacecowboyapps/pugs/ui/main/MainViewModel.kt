package io.spacecowboyapps.pugs.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import io.spacecowboyapps.pugs.data.Repository
import io.spacecowboyapps.pugs.data.db.Pug

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    val pugsList: LiveData<PagedList<Pug>> = repository.getPugs()

    override fun onCleared() {
        super.onCleared()
        repository.onCleared()
    }
}