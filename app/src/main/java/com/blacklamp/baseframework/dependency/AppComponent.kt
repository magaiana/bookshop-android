package com.blacklamp.baseframework.dependency

import android.app.Application
import com.blacklamp.baseframework.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        AppModule::class,
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        AppActivityBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication>{
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : AppComponent.Builder

        fun build() : AppComponent
    }
}