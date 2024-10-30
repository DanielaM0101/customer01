package com.example.customer1.service


import com.example.customer1.dto.CustomerDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.example.customer1.repository.CustomerRepository
import com.example.customer1.entity.Customer
import com.example.customer1.mapper.CustomerMapper


@Service
class CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    fun getAllCustomers() : List<Customer>{
        return customerRepository.findAll()
    }

    fun save( customerDto: CustomerDto): Customer {
        val customer = CustomerMapper.toEntity(customerDto)
        return customerRepository.save(customer)
    }
}