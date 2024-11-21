package com.example.customer1.Controller

import com.example.customer1.entity.ActivityLeadView
import com.example.customer1.service.ActivityViewService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/activity-lead-views")
class ActivityViewController(
val  activityViewService: ActivityViewService
) {
    @GetMapping
    fun getAllActivityLeadViews(): List<ActivityLeadView> = activityViewService.getAllActivityLeadViews()
}