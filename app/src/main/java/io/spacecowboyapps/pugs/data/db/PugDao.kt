package io.spacecowboyapps.pugs.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface PugDao {
    @Insert
    fun insertAll(pugs: List<Pug>)

    @Query("SELECT * FROM pug")
    fun getAll(): LiveData<List<Pug>>
}