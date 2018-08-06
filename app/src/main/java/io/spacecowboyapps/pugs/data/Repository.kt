package io.spacecowboyapps.pugs.data

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import io.spacecowboyapps.pugs.data.db.Pug

interface Repository{
    fun getPugs(): LiveData<PagedList<Pug>>
    fun onCleared()
}