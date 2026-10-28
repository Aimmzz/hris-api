package com.aimcode.hris_api.dto

import jakarta.validation.constraints.NotBlank

data class EmployeeRequest (

    @field:NotBlank(message = "Name tidak boleh kosong")
    val name: String,

    @field:NotBlank(message = "Position tidak boleh kosong")
    val position: String
)

data class EmployeeResponse (
    val id: String,
    val name: String,
    val position: String
)