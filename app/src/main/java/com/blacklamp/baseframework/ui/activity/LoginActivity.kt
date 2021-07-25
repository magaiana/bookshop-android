package com.blacklamp.baseframework.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blacklamp.baseframework.ui.viewmodels.AuthViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}