package com.aimcode.hris_api.controller

import com.aimcode.hris_api.dto.AuthRequest
import com.aimcode.hris_api.dto.AuthResponse
import com.aimcode.hris_api.service.AuthService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController (private val authService: AuthService) {

    @PostMapping("/register")
    fun register(@Valid @RequestBody request: AuthRequest): AuthResponse {
        return authService.register(request)
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: AuthRequest): AuthResponse {
        return authService.login(request)
    }
}