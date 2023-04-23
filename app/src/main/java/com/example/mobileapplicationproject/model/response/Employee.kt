package com.example.mobileapplicationproject.model.response

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
data class Employee(
    @Serializable
    val biography: String,
    @Serializable
    val email_address: String,
    @Serializable
    val employee_type: String,
    @Serializable
    val full_name: String,
    @Serializable
    val phone_number: String,
    @Serializable
    val photo_url_large: String,
    @Serializable
    val photo_url_small: String,
    @Serializable
    val team: String,
    @Serializable
    val uuid: String
)