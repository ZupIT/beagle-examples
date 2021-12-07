package br.com.beaglesampleBackend.service

import com.example.bffsampleflex.builder.FlexScreenBuilder
import org.springframework.stereotype.Service

@Service
class FlexScreenService {
    fun getFlexScreenBuilder() = FlexScreenBuilder
}