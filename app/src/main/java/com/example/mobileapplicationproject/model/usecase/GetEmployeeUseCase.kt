package com.example.mobileapplicationproject.model.usecase

import com.example.mobileapplicationproject.model.response.Employees

interface GetEmployeeUseCase {
    suspend fun getEmployees(): Employees
}