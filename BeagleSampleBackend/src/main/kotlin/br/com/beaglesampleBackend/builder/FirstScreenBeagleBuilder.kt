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

package br.com.beaglesampleBackend.builder

import br.com.zup.beagle.ext.setFlex
import br.com.zup.beagle.ext.setStyle
import br.com.zup.beagle.widget.core.AlignSelf
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Text

class FirstScreenBeagleBuilder : ScreenBuilder {
    override fun build() = Screen(
            child = Container(
                    children = listOf(
                            Text(
                                    text = "Hello Beagle",
                                    styleId = "TextStyle"
                            ).setStyle {
                                    margin = EdgeValue.only(top = 16)
                            }.setFlex {
                                    alignSelf = AlignSelf.CENTER
                            },
                            Text(
                                    text = "Beagle is a cross-platform framework which provides usage of the " +
                                            "Server-Driven UI concept, natively in iOS, Android and Web applications." +
                                            "By using Beagle, your team could easily change application's layout and" +
                                            " data by just changing backend code."
                            ).setStyle {
                                    margin = EdgeValue.only(top = 20, right = 16, left = 16)
                            }
                    )
            )
    )
}