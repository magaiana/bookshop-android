package com.blacklamp.incwadi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import com.blacklamp.incwadi.data.network.UserService
import com.blacklamp.incwadi.data.network.RetrofitInstance

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesUserService(): UserService {
        var retrofit =  RetrofitInstance.create()
        return retrofit.create(UserService::class.java)
    }
}