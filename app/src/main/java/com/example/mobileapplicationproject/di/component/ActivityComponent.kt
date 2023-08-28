package com.example.mobileapplicationproject.di.component

import com.example.mobileapplicationproject.MainActivity
import com.example.mobileapplicationproject.di.module.ViewModelModule
import com.example.mobileapplicationproject.di.scopes.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ViewModelModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}