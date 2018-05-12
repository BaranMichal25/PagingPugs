package io.spacecowboyapps.pugs.data

import android.arch.lifecycle.LiveData
import io.spacecowboyapps.pugs.data.db.Pug

interface Repository{
    fun getPugs(): LiveData<List<Pug>>
}