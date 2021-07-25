package com.blacklamp.baseframework.di

import android.app.Application
import com.blacklamp.baseframework.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesArticleDatabase(context: Application) = AppDatabase(context)

    @Singleton
    @Provides
    fun providesUserDao(database: AppDatabase) = database.getUserDao()
}