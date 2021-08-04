package com.example.bffsampleflex.service

import br.com.zup.beagle.widget.layout.ScreenBuilder
import com.example.bffsampleflex.builder.FlexScreenBuilder
import org.springframework.stereotype.Service

@Service
class FlexScreenService {
    fun getFlexScreenBuilder() = FlexScreenBuilder
}