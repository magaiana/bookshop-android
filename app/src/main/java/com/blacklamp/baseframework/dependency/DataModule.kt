package com.blacklamp.baseframework.dependency

import dagger.Binds
import dagger.Module
import javax.inject.Singleton
import com.blacklamp.baseframework.data.repositories.IUserRepository
import com.blacklamp.baseframework.data.repositories.UserRepository

@Module(
    includes = [
        NetworkModule::class
    ]
)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideUserRepository(repositoryImpl: UserRepository) : IUserRepository
}