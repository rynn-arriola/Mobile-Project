package com.example.mobileapplicationproject.di.module

import android.content.Context
import android.content.res.Resources
import androidx.fragment.app.Fragment
import com.example.mobileapplicationproject.di.qualifiers.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return fragment.requireContext()
    }

    @Provides
    fun provideResource(): Resources {
        return fragment.resources
    }
}