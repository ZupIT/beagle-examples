package br.com.beaglesampleBackend.builder

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.AlignSelf
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.core.TextInputType
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextInput

class PasswordScreenBuilder : ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                navigationBar = NavigationBar(
                        title = "senha iti",
                        showBackButton = true,
                        styleId = "toolbar"
                ),
                child = Container(
                        context = ContextData(
                                id = "password",
                                value = ""
                        ),
                        children = listOf(
                                TextInput(
                                        placeholder = "SENHA",
                                        styleId = "TextInput",
                                        type = TextInputType.PASSWORD,
                                        onChange = listOf(
                                                SetContext(
                                                        contextId = "password",
                                                        value = "@{onChange.value}"
                                                )
                                        )

                                ).applyStyle(Style(margin = EdgeValue(horizontal = 8.unitReal()))),
                                createdButton()

                        )
                ).applyStyle(
                        Style(
                                flex = Flex(
                                        grow = 1.0
                                )
                        )
                )
        )
    }

    private fun createdButton(): Container {
        return Container(
                children = listOf(
                        Text(text = "recuperar senha ", styleId = "TextStyle").applyStyle(
                                Style(
                                        margin = EdgeValue(all = 8.unitReal()),
                                        flex = Flex(alignSelf = AlignSelf.CENTER)
                                )
                        ),
                        Button(
                                text = "entrar",
                                styleId = "button",
                                onPress = listOf(
                                        Navigate.OpenNativeRoute(route = "screen-native")
                                )
                        ).applyStyle(
                                Style(
                                        cornerRadius = CornerRadius(radius = 20.0)
                                )
                        )
                )
        ).applyStyle(
                Style(
                        flex = Flex(
                                justifyContent = JustifyContent.FLEX_END,
                                grow = 1.0
                        ),
                        margin = EdgeValue(horizontal = 8.unitReal(), bottom = 16.unitReal())
                )
        )
    }
}