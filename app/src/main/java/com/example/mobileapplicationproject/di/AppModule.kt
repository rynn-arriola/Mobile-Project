package com.example.mobileapplicationproject.di


import android.app.Application
import android.content.res.Resources
import com.example.mobileapplicationproject.model.EmployeeRepoImpl
import com.example.mobileapplicationproject.model.EmployeesRepo
import com.example.mobileapplicationproject.model.network.EmployeeApi
import com.example.mobileapplicationproject.model.usecase.GetEmployeeUseCase
import com.example.mobileapplicationproject.model.usecase.GetEmployeeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

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

    @Provides
    fun provideResources(application: Application): Resources {
        return application.resources
    }

}