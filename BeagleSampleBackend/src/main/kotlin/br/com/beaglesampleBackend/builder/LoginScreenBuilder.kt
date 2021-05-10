package br.com.beaglesampleBackend.builder

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.ext.setFlex
import br.com.zup.beagle.ext.setStyle
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.core.TextInputType
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextInput

class LoginScreenBuilder: ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                navigationBar = NavigationBar(
                        title = "entrar",
                        showBackButton = true,
                        styleId = "toolbar"
                ),
                child = Container(
                        context = ContextData(
                                id = "credential",
                                value = ""
                        ),
                        children = listOf(
                                Text(text = "digite seu CPF ou CNPJ").setStyle {
                                        margin = EdgeValue.all(8)
                                },
                                TextInput(
                                        placeholder = "CPF ou CNPJ",
                                        type = TextInputType.NUMBER,
                                        styleId = "TextInput",
                                        onChange = listOf(
                                                SetContext(
                                                        contextId = "credential",
                                                        value = "@{onChange.value}"
                                                )
                                        )

                                ).setStyle {
                                        margin = EdgeValue.horizontal(8)
                                },
                                createdButton()

                        )
                ).setFlex {
                        grow = 1.0
                }
        )
    }

    private fun createdButton(): Container {
        return Container(
                children = listOf(
                        Button(
                                text = "continuar",
                                styleId = "button",
                                onPress = listOf(
                                        SetContext(
                                                contextId = "global",
                                                value = "@{credential}"
                                        ),
                                        Navigate.PushView(route = Route.Remote("/password",shouldPrefetch = true))
                                )
                        ).setStyle {
                                cornerRadius = CornerRadius(radius = 20.0)
                        }
                )
        ).setStyle {
                margin = EdgeValue.only(left = 8, right = 8, bottom = 16)
        }.setFlex {
                grow = 1.0
                justifyContent = JustifyContent.FLEX_END
        }
    }
}