package com.example.customer1.exception

import com.example.customer1.response.JsendResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<JsendResponse<List<String>>> {
        val errors = ex.bindingResult.fieldErrors.map { it.defaultMessage ?: "Invalid value" }
        val response = JsendResponse(status = "fail", data = errors)
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneralExceptions(ex: Exception): ResponseEntity<JsendResponse<String?>> {
        val response = JsendResponse<String?>(
            status = "error",
            message = ex.message ?: "An unexpected error occurred",
            data = null
        )
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}