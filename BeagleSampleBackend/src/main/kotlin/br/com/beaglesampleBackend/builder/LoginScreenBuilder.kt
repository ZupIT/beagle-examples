package br.com.beaglesampleBackend.builder

import br.com.beaglesampleBackend.action.AuthenticationAction
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.ext.setFlex
import br.com.zup.beagle.ext.setStyle
import br.com.zup.beagle.platform.BeaglePlatform
import br.com.zup.beagle.platform.setPlatform
import br.com.zup.beagle.widget.action.*
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
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

class LoginScreenBuilder : ScreenBuilder {
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
                                Container(
                                        listOf(
                                                Button(
                                                        text = "Autenticação por biometria",
                                                        onPress = listOf(
                                                                AuthenticationAction(
                                                                        success = listOf(
                                                                                Navigate.OpenNativeRoute(route = "screen-native")
                                                                        ),
                                                                        error = listOf(
                                                                                Alert(
                                                                                        title = "Erro de Authenticação",
                                                                                        message = "Faça o Login normalmente com cpf e password"
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                ).setStyle {
                                                    margin = EdgeValue.only(top = 15)
                                                }
                                        )
                                ).setPlatform(BeaglePlatform.MOBILE),
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
                                        Condition(
                                                condition = expressionOf("@{eq(credential, '123456789')}"),
                                                onFalse = listOf(
                                                        Alert(
                                                                title = "Atenção",
                                                                message = "CPF invalido!"
                                                        )
                                                ),
                                                onTrue = listOf(
                                                        Navigate.PushView(route = Route.Remote("/password", shouldPrefetch = true))
                                                )
                                        )
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