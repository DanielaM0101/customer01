package com.example.customer1.mapper

import com.example.customer1.dto.CustomerDto
import com.example.customer1.entity.Customer


object CustomerMapper {

    fun toEntity(customerDto: CustomerDto): Customer {
        val customer = Customer()
        customer.fullName = customerDto.fullName
        customer.email = customerDto.email
        return customer

    }

}