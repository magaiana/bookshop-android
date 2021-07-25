package com.blacklamp.baseframework.repositories

import com.blacklamp.baseframework.data.local.dao.UserDao
import com.blacklamp.baseframework.data.local.entities.UserEntity
import com.blacklamp.baseframework.data.network.UserService
import com.blacklamp.baseframework.models.UserResponse
import retrofit2.Response

class UserRepositoryImpl(private val userDao: UserDao, private val userService: UserService) : IUserRepository {

    override suspend fun authenticateUser(username: String,password: String): Response<UserResponse>  =
        userService.login(username, password)

    override suspend fun saveUserLocally(user: UserEntity) =
        userDao.upsert(user)

    override suspend fun delete(user: UserEntity) =
        userDao.deleteUser(user)

    override fun getLocalUser() =
        userDao.getUser()
}