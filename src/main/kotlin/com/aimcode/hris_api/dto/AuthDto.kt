package com.aimcode.hris_api.dto

import jakarta.validation.constraints.NotBlank

data class AuthRequest(
    @field:NotBlank(message = "Username tidak boleh kosong")
    val username: String,

    @field:NotBlank(message = "Password tidak boleh kosong")
    val password: String
)

data class AuthResponse(
    val token: String,
)