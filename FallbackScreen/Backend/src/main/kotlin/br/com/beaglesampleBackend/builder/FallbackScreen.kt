/*
 *  Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package br.com.beaglesampleBackend.builder

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.ext.setFlex
import br.com.zup.beagle.ext.setStyle
import br.com.zup.beagle.widget.action.Alert
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

object FallbackScreen : ScreenBuilder {
    override fun build() = Screen(
        navigationBar = NavigationBar(title = "", showBackButton = true, styleId = "sd_fallback_nav_bar"),
        child = Container(
            children = listOf(
                Image(
                    ImagePath.Remote(remoteUrl = "/sadIcon.png")
                ).setStyle {
                    size = Size(width = UnitValue(70.0, UnitType.REAL), height = UnitValue(70.0, UnitType.REAL))
                },
                Text(
                    styleId = "sd_fallback_text",
                    textColor = "#FFFFFF",
                    text = "Desculpe, tivemos algum problema em nossos servidores.",
                    alignment = TextAlignment.CENTER
                ).setStyle {
                    margin = EdgeValue(horizontal = UnitValue(40.0))
                }.setFlex {
                    justifyContent = JustifyContent.CENTER
                },
                Button(
                    text = "Tentar novamente",
                    onPress = listOf(
                        Alert("", "Tentando novamente!")
                    )
                ).setStyle {
                    backgroundColor = "#248260"
                    padding = EdgeValue(horizontal = UnitValue(15.0))
                    cornerRadius = CornerRadius(25.0)
                }
            )
        ).setFlex {
            justifyContent = JustifyContent.SPACE_AROUND
            alignItems = AlignItems.CENTER
            grow = 1.0
        }.setStyle {
            backgroundColor = "#000000"
        }
    )
}