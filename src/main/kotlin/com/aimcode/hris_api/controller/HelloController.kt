package com.aimcode.hris_api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class HelloController {

    @GetMapping("hello")
    fun sayHello(): Map<String, String> {
        return mapOf(
            "message" to "Hello from Aimcode HRIS API!",
            "status" to "Success"
        )
    }

    @GetMapping("ping")
    fun showPing(): Map<String, String> {
        return mapOf(
            "message" to "Pong!"
        )
    }
}