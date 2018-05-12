package io.spacecowboyapps.pugs.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import io.spacecowboyapps.pugs.data.Repository
import javax.inject.Inject

class MainViewModelFactory
@Inject constructor(
    private val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}