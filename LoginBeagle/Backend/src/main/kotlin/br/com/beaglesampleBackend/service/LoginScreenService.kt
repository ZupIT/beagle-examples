package br.com.beaglesampleBackend.service

import br.com.beaglesampleBackend.builder.LoginScreenBuilder
import org.springframework.stereotype.Service

@Service
class LoginScreenService {
    fun createLoginScreen() = LoginScreenBuilder()
}