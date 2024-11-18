package com.example.customer1.mapper

import com.example.customer1.dto.ActivityDto
import com.example.customer1.entity.Activity
import com.example.customer1.entity.Lead
import java.time.LocalDateTime

object ActivityMapper {
    fun Activity.toDTO(): ActivityDto = ActivityDto(
        id = this.id,
        description = this.description,
        timestamp = this.timestamp,
        leadId = this.lead.id
    )

    fun ActivityDto.toEntity(lead: Lead): Activity = Activity(
        description = this.description,
        timestamp = this.timestamp,
        lead = lead
    )
}
