package com.blacklamp.baseframework.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.blacklamp.baseframework.R
import com.blacklamp.baseframework.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
    }
}