package br.com.beaglesampleBackend.service

import br.com.beaglesampleBackend.builder.GetStartedScreenBuilder
import org.springframework.stereotype.Service

@Service
class GetStartedScreenService {
    fun createGetStartedScreen() = GetStartedScreenBuilder()
}