package com.example.customer1.entity

import jakarta.persistence.*


@Entity
@Table(name = "leads")
data class Lead(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var status: String
)
