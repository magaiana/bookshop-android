package com.blacklamp.baseframework.data.repositories

import com.blacklamp.baseframework.models.AuthResponse
import com.blacklamp.baseframework.data.network.HttpCalls
import com.blacklamp.baseframework.data.localStore.AppDatabase
import com.blacklamp.baseframework.data.localStore.entities.UserEntity
import com.blacklamp.baseframework.data.network.helpers.HttpRequestProxy
import javax.inject.Inject

class UserRepository: HttpRequestProxy {

    private lateinit var server: HttpCalls
    private lateinit var local: AppDatabase

    @Inject
    constructor(server: HttpCalls, local: AppDatabase) {
        this.local = local
        this.server = server
    }

    suspend fun authenticateUser(username: String, password: String): AuthResponse {

        return apiRequest {
            server.login(username, password)
        }
    }

    fun saveUser(user: UserEntity) {
        local.getUserDao().upsert(user)
    }

    fun getUser() = local.getUserDao().getUser()
}