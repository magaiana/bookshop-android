package com.blacklamp.baseframework.models

import com.blacklamp.baseframework.data.localStore.entities.UserEntity

data class AuthResponse (
    val isSuccessful: Boolean?,
    val message: String?,
    val user: UserEntity?
)