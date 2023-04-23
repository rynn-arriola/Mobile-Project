package com.example.mobileapplicationproject.model.network

import com.example.mobileapplicationproject.model.response.Employees
import retrofit2.http.GET

interface EmployeeApi {

    companion object {
        const val BASE_URL = "https://s3.amazonaws.com/sq-mobile-interview/"
    }

//Here we can uncomment each end point that we want to load to test our error handling on the view model.
// check other end point to see how it looks like on the UI when something went wrong

    @GET("employees.json")
    suspend fun getEmployees(): Employees

//    @GET("employees_malformed.json")
//    suspend fun getEmployees() : Employees

//    @GET("employees_empty.json")
//    suspend fun getEmployees() : Employees
}