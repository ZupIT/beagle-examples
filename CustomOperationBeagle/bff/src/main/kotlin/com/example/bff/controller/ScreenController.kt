package com.example.bff.controller

import com.example.bff.service.IsValidPasswordService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ScreenController(
        private val isValidPasswordService: IsValidPasswordService
) {
    @GetMapping("/isValidPassword")
    fun getIsValidPasswordScreen() = isValidPasswordService.createIsValidPasswordBuilder()
}