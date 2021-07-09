package com.blacklamp.baseframework.ui.auth

import com.blacklamp.baseframework.data.localStore.entities.UserEntity

interface AuthEventListener {
    fun OnStarted()
    fun OnSuccess(loginResponse: UserEntity)
    fun OnFailure(message: String)
}