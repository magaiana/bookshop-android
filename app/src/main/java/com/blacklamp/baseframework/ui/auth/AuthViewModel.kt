package com.blacklamp.baseframework.ui.auth

import android.view.View
import android.content.Context
import androidx.lifecycle.ViewModel
import com.blacklamp.baseframework.data.repositories.UserRepository
import com.blacklamp.baseframework.utils.ApiException
import com.blacklamp.baseframework.utils.Coroutines
import com.blacklamp.baseframework.utils.NoInternetException

class AuthViewModel(private val repository: UserRepository) : ViewModel() {

    var username: String? = null
    var password: String? = null
    var authEventListener: AuthEventListener? = null

    fun getLoggedInUser() = repository.getUser()

    fun onLoginClicked(view: View) {
        authEventListener?.OnStarted()

        if (username?.isNullOrEmpty() == true && password?.isNullOrEmpty() == true) {
            authEventListener?.OnFailure("Invalid username or password")
            return
        }

        Coroutines.main {
            try {
                val authResponse = repository.authenticateUser(username!!, password!!)
                authResponse.user?.let {
                    authEventListener?.OnSuccess(it)

                    repository.saveUser(it)
                    return@main
                }
                authEventListener?.OnFailure(authResponse.message!!)
            } catch (ex: ApiException) {
                authEventListener?.OnFailure("Error code: ${ex.message}")
            }catch (ex: NoInternetException){
                authEventListener?.OnFailure("Error: ${ex.message}")
            }
        }
    }
}