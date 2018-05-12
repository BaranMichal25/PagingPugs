package io.spacecowboyapps.pugs.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Pug::class], version = 1)
abstract class Database: RoomDatabase(){
    abstract fun pugDao(): PugDao

    companion object {
        const val DATABASE_NAME = "PugsDatabase"
    }
}