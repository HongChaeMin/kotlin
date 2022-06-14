package com.example.kotlinserver.util

// https://www.geeksforgeeks.org/how-to-handle-api-responses-success-error-in-android/
sealed class ApiResponse<T> (
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(data: T) : ApiResponse<T>(data = data)
    class Error<T>(errorMessage: String) : ApiResponse<T>(message = errorMessage)
}