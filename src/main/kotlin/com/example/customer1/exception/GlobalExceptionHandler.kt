package com.example.customer1.exception

import com.example.customer1.response.JsendResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice  //manejar excepciones
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class) //maneja las excepciones de validacion
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<JsendResponse<List<String>>> { //resive la excepcion y devuelve un response entity
        val errors = ex.bindingResult.fieldErrors.map { it.defaultMessage ?: "Invalid value" } // mapea los errores
        val response = JsendResponse(status = "fail", data = errors) // crea un response
        return ResponseEntity(response, HttpStatus.BAD_REQUEST) //devuelve el response
    }

    @ExceptionHandler(Exception::class) //maneja las excepciones generales
    fun handleGeneralExceptions(ex: Exception): ResponseEntity<JsendResponse<String?>> {//resive la excepcion y devuelve un response entity
        val response = JsendResponse<String?>( // crea un response
            status = "error", // con el status error
            message = ex.message ?: "An unexpected error occurred", // y el mensaje de la excepcion
            data = null // y los datos nulos
        )
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR) //devuelve el response
    }
}