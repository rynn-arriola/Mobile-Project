package com.example.mobileapplicationproject.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobileapplicationproject.di.ViewModelFactory
import com.example.mobileapplicationproject.di.qualifiers.ViewModelKey
import com.example.mobileapplicationproject.viewmodel.EmployeesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(EmployeesViewModel::class)
    abstract fun bindEmployeesViewModel(viewModel: EmployeesViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
