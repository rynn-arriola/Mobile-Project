package com.example.mobileapplicationproject

import com.example.mobileapplicationproject.di.module.ApplicationModule
import android.app.Application
import com.example.mobileapplicationproject.di.component.ApplicationComponent
import com.example.mobileapplicationproject.di.component.DaggerApplicationComponent


class EmployeeApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {
        applicationComponent =
            DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}