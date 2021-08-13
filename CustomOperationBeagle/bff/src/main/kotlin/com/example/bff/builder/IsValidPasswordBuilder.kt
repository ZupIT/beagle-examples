package com.example.bff.builder

import br.com.zup.beagle.ext.setFlex
import br.com.zup.beagle.ext.setStyle
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.AlignContent
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.TextInputType
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextInput

object IsValidPasswordBuilder : ScreenBuilder {

    override fun build() = Screen(
            navigationBar = NavigationBar(
                    title = "IsValidPassword Operation"
            ),
            child = Container(
                    children = listOf(
                            TextInput(
                                    placeholder = "senha",
                                    type = TextInputType.PASSWORD,
                                    onChange = listOf(
                                            SetContext(
                                                    contextId = "password",
                                                    value = "@{onChange.value}"
                                            )
                                    )
                            ).setStyle { margin = EdgeValue.only(bottom = 10) },
                            Text(text = "Informe uma senha de no mínimo 6 caracteres com pelo menos uma letra, um número e um caractere especial (@$!%*#?&).").setStyle{ margin = EdgeValue.only(bottom = 10) },
                            Text(text = "@{condition(isValidPassword(password), 'Senha válida.', 'Senha inválida.')}")
                    ),
                    context = ContextData(
                            id = "password",
                            value = ""
                    )
            ).setStyle {
                margin = EdgeValue.only(left = 20, right = 20, top = 10)
            }.setFlex {
                alignContent = AlignContent.CENTER
            }
    )

}