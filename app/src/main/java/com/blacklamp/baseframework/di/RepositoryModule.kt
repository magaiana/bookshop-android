package com.blacklamp.baseframework.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import com.blacklamp.baseframework.data.local.dao.UserDao
import com.blacklamp.baseframework.data.network.UserService
import com.blacklamp.baseframework.repositories.IUserRepository
import com.blacklamp.baseframework.repositories.UserRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesUserRepository(userDao: UserDao, userService: UserService) : IUserRepository {
        return UserRepositoryImpl(userDao, userService)
    }
}