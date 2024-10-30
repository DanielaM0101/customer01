package com.example.customer1.response

data class JsendResponse<T>(
    val status: String,
    val data: T? = null,
    val message: String? = null,
    val code: Int? = null
)