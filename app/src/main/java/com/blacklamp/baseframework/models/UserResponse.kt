package com.blacklamp.baseframework.models

data class UserResponse (
    val isSuccessful: Boolean?,
    val message: String?,
    val user: UserModel?
)