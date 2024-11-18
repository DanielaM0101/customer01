package com.example.customer1.repository

import com.example.customer1.entity.Activity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ActivityRepository : JpaRepository<Activity, Long> {
    fun findAllByLeadId(leadId: Long): List<Activity> // Busca actividades por ID de Lead
}
