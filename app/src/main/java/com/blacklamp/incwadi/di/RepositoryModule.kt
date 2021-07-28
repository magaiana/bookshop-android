package com.blacklamp.incwadi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import com.blacklamp.incwadi.data.local.dao.UserDao
import com.blacklamp.incwadi.data.network.UserService
import com.blacklamp.incwadi.repositories.IUserRepository
import com.blacklamp.incwadi.repositories.UserRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesUserRepository(userDao: UserDao, userService: UserService) : IUserRepository {
        return UserRepositoryImpl(userDao, userService)
    }
}