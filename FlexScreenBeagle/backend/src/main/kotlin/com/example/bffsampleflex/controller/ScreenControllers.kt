package com.example.bffsampleflex.controller

import com.example.bffsampleflex.builder.FlexScreenBuilder
import com.example.bffsampleflex.service.FlexScreenService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ScreenControllers(
        private val sampleFlexScreen: FlexScreenService
) {
    @GetMapping("/sampleFlexScreen")
    fun getFlexScreen() = sampleFlexScreen.getFlexScreenBuilder()
}