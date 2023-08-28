package com.example.mobileapplicationproject.di.module

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import com.example.mobileapplicationproject.di.qualifiers.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideResources(): Resources{
        return activity.resources
    }
}