package com.blacklamp.baseframework.dependency

import androidx.room.ForeignKey
import com.blacklamp.baseframework.dependency.scopes.ActivityScoped
import com.blacklamp.baseframework.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun provideMainActivity() : HomeActivity

    //@ActivityScoped
    //@ContributesAndroidInjector
    //abstract fun provideIntroActivity()  //: IntroActivity
}