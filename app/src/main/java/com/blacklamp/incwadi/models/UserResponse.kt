package com.blacklamp.incwadi.models

data class UserResponse (
    val isSuccessful: Boolean?,
    val message: String?,
    val user: UserModel?
)