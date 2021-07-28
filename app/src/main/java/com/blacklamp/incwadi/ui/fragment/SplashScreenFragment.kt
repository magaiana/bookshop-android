package com.blacklamp.incwadi.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import kotlinx.coroutines.*
import android.view.WindowManager
import com.blacklamp.incwadi.R
import androidx.fragment.app.Fragment
import kotlin.coroutines.CoroutineContext
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController
import com.blacklamp.incwadi.ui.activity.StartupActivity
import com.blacklamp.incwadi.databinding.FragmentSplashScreenBinding

@AndroidEntryPoint
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen)  , CoroutineScope {

    private lateinit var binding: FragmentSplashScreenBinding
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as StartupActivity).binding.bottomNavigationView.visibility = View.GONE
        binding = FragmentSplashScreenBinding.bind(view)

        launch {
            delay(2000)
            withContext(Dispatchers.Main){
                findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
                (activity as StartupActivity).binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }
}