package com.blacklamp.baseframework.data.repositories

import com.blacklamp.baseframework.models.AuthResponse
import com.blacklamp.baseframework.data.localStore.entities.UserEntity

interface IUserRepository {

    suspend fun authenticateUser(username: String, password: String): AuthResponse

    fun saveUser(user: UserEntity)

    fun getUser()

}