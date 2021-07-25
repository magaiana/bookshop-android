package com.blacklamp.baseframework.data.local

import androidx.room.Room
import androidx.room.Database
import android.content.Context
import androidx.room.RoomDatabase
import com.blacklamp.baseframework.data.local.dao.UserDao
import com.blacklamp.baseframework.data.local.entities.UserEntity
import com.blacklamp.baseframework.utils.Constants.Companion.DATABASE_NAME

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries()
                .build()
    }
}