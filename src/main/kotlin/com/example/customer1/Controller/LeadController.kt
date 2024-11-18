package com.example.customer1.Controller

import com.example.customer1.dto.LeadDto
import com.example.customer1.entity.Lead
import com.example.customer1.service.LeadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/leads")
class LeadController(
    private val leadService: LeadService
) {
    @GetMapping
    fun getAllLeads(): List<LeadDto> = leadService.getAllLeads()

    @GetMapping("/{id}")
    fun getLeadById(@PathVariable id: Long): LeadDto = leadService.getLeadById(id)

    @PostMapping
    fun createLead(@RequestBody leadDTO: LeadDto): LeadDto = leadService.createLead(leadDTO)


    @PostMapping("/{id}/set-status")
    fun updateLeadStatus(@PathVariable id: Long, @RequestBody status: String): LeadDto=
        leadService.updateLeadStatus(id, status)

    @GetMapping("/{id}/status")
    fun getLeadStatus(@PathVariable id: Long): String = leadService.getLeadStatus(id)
}

