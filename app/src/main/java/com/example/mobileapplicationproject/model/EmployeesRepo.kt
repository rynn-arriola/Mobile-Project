package com.example.mobileapplicationproject.model

import com.example.mobileapplicationproject.model.response.Employees

interface EmployeesRepo {
    suspend fun getEmployees(): Employees
}