package br.com.beaglesampleBackend.service

import br.com.beaglesampleBackend.builder.HomeCarouselOptions
import br.com.beaglesampleBackend.builder.PaginatedListBuilder
import org.springframework.stereotype.Service

@Service
class PaginatedListService {
    fun getPaginatedList() = PaginatedListBuilder.build()
}