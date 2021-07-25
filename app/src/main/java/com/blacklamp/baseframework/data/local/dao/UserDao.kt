package com.blacklamp.baseframework.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.blacklamp.baseframework.data.local.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: UserEntity): Long

    @Query("SELECT * FROM user")
    fun getUser(): UserEntity

    @Delete
    suspend fun deleteUser(user: UserEntity)
}