package com.example.customer1.Controller

import com.example.customer1.dto.ActivityDto
import com.example.customer1.entity.Activity
import com.example.customer1.service.ActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/leads/{leadId}/activities")
class ActivityController(
    private val activityService: ActivityService
) {
    @GetMapping
    fun getActivitiesForLead(@PathVariable leadId: Long): List<ActivityDto> =
        activityService.getActivitiesForLead(leadId)

    @PostMapping
    fun createActivityForLead(@PathVariable leadId: Long, @RequestBody activityDTO: ActivityDto): ActivityDto =
        activityService.createActivityForLead(leadId, activityDTO)
}