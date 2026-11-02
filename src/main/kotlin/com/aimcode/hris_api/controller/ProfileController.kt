package com.aimcode.hris_api.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/profile")
class ProfileController {

    @GetMapping("/me")
    fun getMyProfile(): Map<String, String?> {
        val authentication = SecurityContextHolder.getContext().authentication
        val currentUsername = authentication?.name

        return mapOf(
            "message" to "Berhasil masuk ke area terlarang!",
            "loggedInAs" to currentUsername
        )
    }
}