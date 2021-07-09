package com.blacklamp.baseframework.data.localStore.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.blacklamp.baseframework.utils.Constants.Companion.CURRENT_USER_ID

@Entity(tableName = "user")
data class UserEntity(
    val id: Int? = null,
    val firstName: String? = null
) {
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}