package br.com.beaglesampleBackend.service

import br.com.beaglesampleBackend.builder.IsValidPasswordBuilder
import org.springframework.stereotype.Service

@Service
class IsValidPasswordService {
    fun createIsValidPasswordBuilder() = IsValidPasswordBuilder
}