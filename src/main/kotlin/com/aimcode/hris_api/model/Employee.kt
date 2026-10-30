package com.aimcode.hris_api.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "employees")
class Employee (

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String? = null,

    var name: String,

    var position: String
)