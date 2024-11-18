package com.example.customer1.repository

import com.example.customer1.entity.Lead
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface LeadRepository  : JpaRepository<Lead, Long>
