
package com.example.customer1.Controller

import com.example.customer1.dto.CustomerDto
import com.example.customer1.entity.Customer
import com.example.customer1.response.JsendResponse
import com.example.customer1.service.CustomerService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController {
    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping
    fun getCustomers(): JsendResponse<List<Customer>> {
        val customers = customerService.getAllCustomers()
        return JsendResponse(status = "success", data = customers)
    }

    @PostMapping
    fun save(@RequestBody @Valid customerDto: CustomerDto): JsendResponse<Customer> {
        val customer = customerService.save(customerDto)
        return JsendResponse(status = "success", data = customer)
    }
}