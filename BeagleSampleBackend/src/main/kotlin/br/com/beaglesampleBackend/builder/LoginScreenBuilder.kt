package br.com.beaglesampleBackend.builder

import br.com.zup.beagle.builder.widget.flex
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.AlignSelf
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.FlexDirection
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
                                Text(text = "digite seu CPF ou CNPJ").applyStyle(
                                        Style(
                                                margin = EdgeValue(
                                                        all = 8.unitReal()
                                                )
                                        )
                                ),
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
                        ).applyStyle(
                                Style(
                                        backgroundColor = "",
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