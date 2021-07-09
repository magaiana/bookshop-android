package com.blacklamp.baseframework.data.localStore

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.lifecycle.LiveData
import androidx.room.OnConflictStrategy
import com.blacklamp.baseframework.data.localStore.entities.UserEntity
import com.blacklamp.baseframework.utils.Constants.Companion.CURRENT_USER_ID

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: UserEntity): Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser(): LiveData<UserEntity>
}