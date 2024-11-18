package com.example.customer1.mapper
import com.example.customer1.dto.LeadDto
import com.example.customer1.entity.Lead


object LeadMapper {
    fun Lead.toDTO(): LeadDto= LeadDto(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )

    fun LeadDto.toEntity(): Lead = Lead(
        name = this.name,
        email = this.email,
        status = this.status
    )

}