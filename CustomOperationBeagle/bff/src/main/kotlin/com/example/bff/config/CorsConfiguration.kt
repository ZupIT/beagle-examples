package com.example.bff.config

import br.com.zup.beagle.constants.BEAGLE_EXPOSED_HEADERS
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfiguration : WebMvcConfigurer {
  override fun addCorsMappings(registry: CorsRegistry) {
    registry
      .addMapping("/**")
      .allowedOrigins("*")
      .allowedMethods("*")
      .exposedHeaders(*BEAGLE_EXPOSED_HEADERS)
  }
}