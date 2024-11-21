package com.example.customer1.service

import com.example.customer1.entity.ActivityLeadView
import com.example.customer1.repository.ActivityViewRepository
import org.springframework.stereotype.Service

@Service
class ActivityViewService(
    val activityViewRepository: ActivityViewRepository
) {
    fun getAllActivityLeadViews(): List<ActivityLeadView>  {
        return activityViewRepository.findAll()
    }
}

