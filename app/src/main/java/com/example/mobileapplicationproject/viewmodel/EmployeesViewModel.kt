package com.example.mobileapplicationproject.viewmodel

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapplicationproject.R
import com.example.mobileapplicationproject.model.response.Employee
import com.example.mobileapplicationproject.model.response.Employees
import com.example.mobileapplicationproject.model.usecase.GetEmployeeUseCase
import com.example.mobileapplicationproject.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class EmployeesViewModel @Inject constructor(
   private val getEmployeeUseCase: GetEmployeeUseCase,
   private val resource: Resources,
): ViewModel() {

    private val _state = MutableLiveData<State<Employees>>()
    val state: LiveData<State<Employees>>
        get() = _state


    init {
        viewModelScope.launch {
            _state.postValue(State.Loading)
            try {
                val employees = getEmployeeUseCase
                    .getEmployees()
                validateList(employees)
            }catch (e: Exception){
                _state.postValue(e.message?.let { State.Error(it) })
            }
        }
    }

    private fun validateList(employees: Employees) {
        val validEmployees = employees.employees.filterNot {
            it.full_name.isNullOrEmpty() && it.email_address.isNullOrEmpty()
        }
        if (validEmployees.size == employees.employees.size && !validEmployees.isNullOrEmpty()) {
            _state.postValue(State.Success(employees))
        } else {
            _state.postValue(State.Error(resource.getString(R.string.network_error)))
        }
    }

    fun sortEmployeesAlphabetical(employees: List<Employee>): List<Employee>{
        return employees.sortedBy { it.full_name }
    }
}