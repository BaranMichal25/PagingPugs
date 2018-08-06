package io.spacecowboyapps.pugs.data

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.text.format.DateUtils
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.spacecowboyapps.pugs.data.db.Database
import io.spacecowboyapps.pugs.data.db.Pug
import io.spacecowboyapps.pugs.data.network.AppClient
import io.spacecowboyapps.pugs.data.preferences.Preferences
import javax.inject.Inject

class AppRepository
@Inject constructor(
    private val appRestClient: AppClient,
    private val database: Database,
    private val preferences: Preferences
) : Repository {

    private val disposable = CompositeDisposable()

    override fun getPugs(): LiveData<PagedList<Pug>> {
        val dao = database.pugDao()
        if (updateNeeded()) {
            disposable.add(appRestClient.getPugs()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.i(TAG, "Updating database with ${it.size} pugs")
                    dao.deleteAll()
                    dao.insertAll(it)
                    preferences.putLastUpdate(System.currentTimeMillis())
                }, {
                    Log.e(TAG, "Handle errors in future", it)
                }))
        }

        return LivePagedListBuilder(dao.getAllAsDataSource(), 10).build()
    }

    private fun updateNeeded(): Boolean {
        val now = System.currentTimeMillis()
        return now - preferences.getLastUpdate() > DateUtils.MINUTE_IN_MILLIS * 5
    }

    override fun onCleared() {
        disposable.dispose()
    }

    private companion object {
        const val TAG = "APP_REPOSITORY"
    }
}