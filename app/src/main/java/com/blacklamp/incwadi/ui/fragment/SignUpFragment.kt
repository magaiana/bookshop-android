package com.blacklamp.incwadi.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.blacklamp.incwadi.R
import com.blacklamp.incwadi.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private lateinit var binding: FragmentSignUpBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
    }
}