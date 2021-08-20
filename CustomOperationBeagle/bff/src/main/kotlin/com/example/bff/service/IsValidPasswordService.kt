package com.example.bff.service

import com.example.bff.builder.IsValidPasswordBuilder
import org.springframework.stereotype.Service

@Service
class IsValidPasswordService {
    fun createIsValidPasswordBuilder() = IsValidPasswordBuilder
}