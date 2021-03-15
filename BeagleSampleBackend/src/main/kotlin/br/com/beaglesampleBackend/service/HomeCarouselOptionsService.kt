package br.com.beaglesampleBackend.service

import br.com.beaglesampleBackend.builder.HomeCarouselOptions
import org.springframework.stereotype.Service

@Service
class HomeCarouselOptionsService {
    fun getHomeCarouselOptions() = HomeCarouselOptions.build()
}