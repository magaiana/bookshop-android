package com.blacklamp.incwadi.repositories

import com.blacklamp.incwadi.data.local.entities.UserEntity
import com.blacklamp.incwadi.models.UserResponse
import retrofit2.Response

interface IUserRepository {

    suspend fun authenticateUser(username: String, password: String): Response<UserResponse>

    suspend fun saveUserLocally(user: UserEntity) : Long

    suspend fun delete(user: UserEntity) : Unit

    fun getLocalUser() : UserEntity

}