package com.aimcode.hris_api.service

import com.aimcode.hris_api.dto.AuthRequest
import com.aimcode.hris_api.dto.AuthResponse
import com.aimcode.hris_api.model.User
import com.aimcode.hris_api.repository.UserRepository
import com.aimcode.hris_api.security.JwtUtil
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
) {

    fun register(request: AuthRequest): AuthResponse {
        if (userRepository.findByUsername(request.username) != null) {
            throw IllegalArgumentException("Username ${request.username} sudah terdaftar")
        }

        val hashedPassword = passwordEncoder.encode(request.password)

        val user = User(
            username = request.username,
            passwordHash = hashedPassword!!
        )
        userRepository.save(user)

        val token = jwtUtil.generateToken(user.username)
        return AuthResponse(token)
    }

    fun login(request: AuthRequest): AuthResponse {
        val user = userRepository.findByUsername(request.username) ?: throw IllegalArgumentException("Username atau password salah")

        val isPasswordMatch = passwordEncoder.matches(request.password, user.passwordHash)
        if (!isPasswordMatch) {
            throw IllegalArgumentException("Username atau password salah")
        }

        val token = jwtUtil.generateToken(user.username)
        return AuthResponse(token)
    }
}