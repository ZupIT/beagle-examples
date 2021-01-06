package br.com.beaglesampleBackend.service

import br.com.beaglesampleBackend.builder.LoginScreenBuilder
import br.com.beaglesampleBackend.builder.PasswordScreenBuilder
import org.springframework.stereotype.Service

@Service
class PasswordScreenService {
    fun createPasswordScreen() = PasswordScreenBuilder()
}