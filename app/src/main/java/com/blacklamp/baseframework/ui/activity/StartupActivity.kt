package com.blacklamp.baseframework.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.blacklamp.baseframework.databinding.ActivityStartupBinding
import com.blacklamp.baseframework.ui.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartupActivity : AppCompatActivity() {

    lateinit var binding: ActivityStartupBinding
    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeDependencies()
        setNavigationHost()
    }

    private fun initializeDependencies() {
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    private fun setNavigationHost() {
        binding.bottomNavigationView.post {
            binding.bottomNavigationView.setupWithNavController(binding.startupNavHostFragment.findNavController())
        }
    }
}