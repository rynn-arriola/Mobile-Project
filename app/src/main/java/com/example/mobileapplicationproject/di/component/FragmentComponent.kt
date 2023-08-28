package com.example.mobileapplicationproject.di.component

import androidx.fragment.app.Fragment
import com.example.mobileapplicationproject.di.module.FragmentModule
import com.example.mobileapplicationproject.di.module.ViewModelModule
import com.example.mobileapplicationproject.di.scopes.FragmentScope
import com.example.mobileapplicationproject.fragments.EmployeesFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class, ViewModelModule::class])
interface FragmentComponent {

    fun inject( fragment: EmployeesFragment)
}