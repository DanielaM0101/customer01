package com.example.customer1.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "activity_view")
  data class ActivityLeadView (
    @Id val id: Long,
    val description: String,
    val timestamp: LocalDateTime,
    val leadId: Long,
    val leadName: String,

  )
