/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.beaglesampleBackend.controller

import br.com.beaglesampleBackend.builder.FallbackScreen
import br.com.beaglesampleBackend.service.*
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:8080"], maxAge = 3600)
@RestController
class ScreenController(
    private val firstScreenBeagleService: ScreenService,
    private val loginScreenService: LoginScreenService,
    private val passwordScreenService: PasswordScreenService,
    private val carouselOptions: HomeCarouselOptionsService,
    private val paginatedList: PaginatedListService,
    private val fallbackScreen: ScreenService,
    private val getGetStarted:GetStartedScreenService
) {
    @GetMapping("/screen")
    fun getFirstScreen() = firstScreenBeagleService.createScreenBeagle()

    @GetMapping("/login")
    fun getLoginScreen() = loginScreenService.createLoginScreen()

    @GetMapping("/password")
    fun getPasswordScreen() = passwordScreenService.createPasswordScreen()

    @GetMapping("/carousel-options")
    fun getCarouselOptions() = carouselOptions.getHomeCarouselOptions()

    @GetMapping("/paginated-list")
    fun getPaginatedList() = paginatedList.getPaginatedList()

    @GetMapping("/fallback-screen")
    fun getFallbackScreen() = fallbackScreen.createFallbackScreen()

    @GetMapping("/get-started")
    fun getGetStartedScreen() = getGetStarted.createGetStartedScreen()
}