package com.blacklamp.baseframework.repositories

import com.blacklamp.baseframework.data.local.entities.UserEntity
import com.blacklamp.baseframework.models.UserResponse
import retrofit2.Response

interface IUserRepository {

    suspend fun authenticateUser(username: String, password: String): Response<UserResponse>

    suspend fun saveUserLocally(user: UserEntity) : Long

    suspend fun delete(user: UserEntity) : Unit

    fun getLocalUser() : UserEntity

}