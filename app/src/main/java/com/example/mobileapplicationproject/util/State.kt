package com.example.mobileapplicationproject.util


sealed class State<out T> {
    data class Success<T>(val data: T) : State<T>()
    object Loading : State<Nothing>()
    data class Error(val errorMessage: String) : State<Nothing>()
}