package com.example.mobileapplicationproject.model

import com.example.mobileapplicationproject.model.network.EmployeeApi
import com.example.mobileapplicationproject.model.response.Employees
import javax.inject.Inject

internal class EmployeeRepoImpl @Inject constructor(
    private val employeeApi: EmployeeApi
) : EmployeesRepo {

    override suspend fun getEmployees() : Employees {
        return employeeApi.getEmployees()
    }
}