package com.example.mobileapplicationproject.di.module

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.example.mobileapplicationproject.EmployeeApplication
import com.example.mobileapplicationproject.di.qualifiers.ApplicationContext
import com.example.mobileapplicationproject.model.EmployeeRepoImpl
import com.example.mobileapplicationproject.model.EmployeesRepo
import com.example.mobileapplicationproject.model.network.EmployeeApi
import com.example.mobileapplicationproject.model.usecase.GetEmployeeUseCase
import com.example.mobileapplicationproject.model.usecase.GetEmployeeUseCaseImpl
import dagger.Module

import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: EmployeeApplication) {

    @ApplicationContext
    @Provides
    @Singleton
    fun provideApplication(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideEmployeeApi(): EmployeeApi {
        return Retrofit.Builder()
            .baseUrl(EmployeeApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmployeeApi::class.java)
    }

    @Provides
    fun provideEmployeeRepo(employeeApi: EmployeeApi): EmployeesRepo {
        return EmployeeRepoImpl(employeeApi)
    }

    @Provides
    fun provideEmployeeUseCase(employeesRepo: EmployeesRepo): GetEmployeeUseCase {
        return GetEmployeeUseCaseImpl(employeesRepo)
    }
}