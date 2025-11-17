package com.example.opportune.Data

import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Database
import androidx.room.Room

@Database(entities = [JobEntity::class], version = 1, exportSchema = false)
abstract class APPDatabase : RoomDatabase() {
    abstract fun jobdao() :JobDao

    companion object {
        @Volatile private var INSTANCE: APPDatabase? = null

        fun getDatabase(context: Context): APPDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    APPDatabase::class.java,
                    "item_database"
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}