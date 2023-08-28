package com.example.mobileapplicationproject.model.usecase

import com.example.mobileapplicationproject.model.EmployeesRepo
import com.example.mobileapplicationproject.model.response.Employees
import com.example.mobileapplicationproject.util.EmployeeCache
import javax.inject.Inject


class GetEmployeeUseCaseImpl @Inject constructor(
    private val employeesRepo: EmployeesRepo
) : GetEmployeeUseCase {
    override suspend fun getEmployees(): Employees {
        return if (EmployeeCache.employees != null) {
            EmployeeCache.employees ?: getEmployeeList()
        } else {
            getEmployeeList()
        }

    }

    private suspend fun getEmployeeList(): Employees {
        return employeesRepo.getEmployees().also {
            EmployeeCache.employees = it
        }
    }
}