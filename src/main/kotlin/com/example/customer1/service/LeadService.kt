package com.example.customer1.service

import com.example.customer1.dto.LeadDto
import com.example.customer1.entity.Lead
import com.example.customer1.mapper.LeadMapper.toDTO
import com.example.customer1.mapper.LeadMapper.toEntity
import com.example.customer1.repository.LeadRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class LeadService(
    private val leadRepository: LeadRepository
) {
    fun getAllLeads(): List<LeadDto> = leadRepository.findAll().map { it.toDTO() }

    fun getLeadById(id: Long): LeadDto = leadRepository.findById(id).orElseThrow {
        Exception("Lead not found with ID $id")
    }.toDTO()

    fun createLead(leadDTO: LeadDto): LeadDto = leadRepository.save(leadDTO.toEntity()).toDTO()

    fun updateLeadStatus(id: Long, status: String): LeadDto{
        val lead = leadRepository.findById(id).orElseThrow { Exception("Lead not found with ID $id") }
        lead.status = status
        return leadRepository.save(lead).toDTO()
    }

    fun getLeadStatus(id: Long): String {
        val lead = leadRepository.findById(id).orElseThrow { Exception("Lead not found with ID $id") }
        return lead.status
    }
}