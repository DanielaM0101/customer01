package com.example.customer1.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "activities")
data class Activity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    var timestamp: LocalDateTime,

    @ManyToOne
    @JoinColumn(name = "lead_id", nullable = false)
    var lead: Lead
)
