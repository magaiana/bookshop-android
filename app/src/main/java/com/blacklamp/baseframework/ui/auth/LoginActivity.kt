package com.blacklamp.baseframework.ui.auth

import android.content.Intent
import android.os.Bundle
import com.blacklamp.baseframework.R
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import com.blacklamp.baseframework.utils.snackbar
import com.blacklamp.baseframework.models.UserModel
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.Observer
import com.blacklamp.baseframework.data.localStore.AppDatabase
import com.blacklamp.baseframework.data.localStore.entities.UserEntity
import com.blacklamp.baseframework.data.network.HttpCalls
import com.blacklamp.baseframework.data.network.helpers.HttpRequestInterceptor
import com.blacklamp.baseframework.data.repositories.UserRepository
import com.blacklamp.baseframework.databinding.ActivityLoginBinding
import com.blacklamp.baseframework.ui.home.HomeActivity
import dagger.multibindings.IntKey
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), AuthEventListener {

    private var rootLayout: CoordinatorLayout? = null
    private lateinit var repository: UserRepository
    private lateinit var factory: AuthViewModelFactory
    private lateinit var httpRequestInterceptor: HttpRequestInterceptor

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.authViewModel = viewModel

        viewModel.authEventListener = this
        rootLayout = findViewById(R.id.root_layout)

        viewModel.getLoggedInUser().observe(this, { user ->
            if (user != null) {
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    private fun init() {
        httpRequestInterceptor = HttpRequestInterceptor(this)

        val server = HttpCalls(httpRequestInterceptor)
        val local = AppDatabase(this)
        repository = UserRepository(server, local)
        factory = AuthViewModelFactory(repository)
    }

    override fun OnStarted() {
        rootLayout?.snackbar("Login Started")
    }

    override fun OnSuccess(loginResponse: UserEntity) {
        //rootLayout?.snackbar("User ${loginResponse.firstName} is logged in.")
    }

    override fun OnFailure(message: String) {
        rootLayout?.snackbar(message)
    }
}