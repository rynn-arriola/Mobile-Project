package com.example.mobileapplicationproject.di.component

import com.example.mobileapplicationproject.EmployeeApplication
import com.example.mobileapplicationproject.di.module.ApplicationModule
import com.example.mobileapplicationproject.di.module.ViewModelModule
import com.example.mobileapplicationproject.fragments.EmployeesFragment
import com.example.mobileapplicationproject.model.EmployeesRepo
import com.example.mobileapplicationproject.model.network.EmployeeApi
import com.example.mobileapplicationproject.model.usecase.GetEmployeeUseCase
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: EmployeeApplication)

    fun geEmployeeApi(): EmployeeApi

    fun getEmployeeRepo(): EmployeesRepo

    fun getEmployeeUseCase(): GetEmployeeUseCase


}