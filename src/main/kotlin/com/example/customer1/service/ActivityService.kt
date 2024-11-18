package com.example.customer1.service

import com.example.customer1.dto.ActivityDto
import com.example.customer1.entity.Activity
import com.example.customer1.entity.Lead
import com.example.customer1.mapper.ActivityMapper.toDTO
import com.example.customer1.mapper.ActivityMapper.toEntity
import com.example.customer1.repository.ActivityRepository
import com.example.customer1.repository.LeadRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime



@Service
class ActivityService(
    private val activityRepository: ActivityRepository,
    private val leadRepository: LeadRepository
) {
    fun getActivitiesForLead(leadId: Long): List<ActivityDto> {
        val lead = leadRepository.findById(leadId).orElseThrow { Exception("Lead not found with ID $leadId") }
        return activityRepository.findAllByLeadId(leadId).map { it.toDTO() }
    }

    fun createActivityForLead(leadId: Long, activityDTO: ActivityDto): ActivityDto {
        val lead = leadRepository.findById(leadId).orElseThrow { Exception("Lead not found with ID $leadId") }
        return activityRepository.save(activityDTO.toEntity(lead)).toDTO()
    }
}