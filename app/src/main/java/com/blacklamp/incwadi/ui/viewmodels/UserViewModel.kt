package com.blacklamp.incwadi.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.blacklamp.incwadi.repositories.IUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel  @Inject constructor(private val repository: IUserRepository) : ViewModel() {

}