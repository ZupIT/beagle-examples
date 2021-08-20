package br.com.beaglesampleBackend.builder

import br.com.beaglesampleBackend.widget.AccountBalance
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.ext.setFlex
import br.com.zup.beagle.ext.setStyle
import br.com.zup.beagle.widget.action.RequestActionMethod
import br.com.zup.beagle.widget.action.SendRequest
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.*

object HomeCarouselOptions {
    fun build() = Container(
            children = listOf(
                    AccountBalance(value = expressionOf("14.000,00")),
                    carouselOptions()
            )
    )


    private fun carouselOptions() = Container(
            children = listOf(
                    ListView(
                            context = ContextData(
                                    id = "initialContext",
                                    value = ""
                            ),
                            onInit = listOf(
                                    SendRequest(
                                            url = "https://private-93ff3-beagleworkshop.apiary-mock.com/options",
                                            method = RequestActionMethod.GET,
                                            onSuccess = listOf(
                                                    SetContext(
                                                            contextId = "initialContext",
                                                            value = "@{onSuccess.data}"
                                                    )
                                            )
                                    )
                            ),
                            dataSource = expressionOf("@{initialContext}"),
                            direction = ListDirection.HORIZONTAL,
                            templates = templatesList()
                    ).setStyle {
                        size = Size(width = UnitValue(100.0, UnitType.PERCENT))
                    }
            )
    )

    private fun templatesList() = listOf<Template>(
            Template(
                    expressionOf("@{eq(item.title, 'Pix')}"),
                    newItemTemplate()
            ),
            Template(
                    true,
                    simpleItemTemplate()
            )
    )

    private fun newItemTemplate() = Container(listOf(
            Container(
                    listOf(
                            Text(
                                    text = "Novo",
                                    styleId = "h1",
                                    textColor = "#ffffff"
                            ), Image(
                            ImagePath.Remote(remoteUrl = "@{item.icon}")
                    ).setStyle {
                        size = Size(width = UnitValue(40.0, UnitType.REAL), height = UnitValue(40.0, UnitType.REAL))
                    }
                    )

            ).setFlex {
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.SPACE_BETWEEN
            },

            Text(
                    text = "@{item.title}",
                    styleId = "h1",
                    textColor = "#ffffff"
            )
    )
    ).setStyle {
        cornerRadius = CornerRadius(radius = 8.0)
        backgroundColor = "#ff5592"
        size = Size(width = UnitValue(140.0, UnitType.REAL), height = UnitValue(140.0, UnitType.REAL))
        margin = EdgeValue.all(10)
        padding = EdgeValue.all(10)
    }.setFlex {
        justifyContent = JustifyContent.SPACE_BETWEEN
    }

    private fun simpleItemTemplate() = Container(
            listOf(
                    Image(
                            ImagePath.Remote(remoteUrl = "@{item.icon}")
                    ).setStyle {
                        size = Size(width = UnitValue(40.0, UnitType.REAL), height = UnitValue(40.0, UnitType.REAL))
                    }.setFlex {
                        alignSelf = AlignSelf.FLEX_END
                    },
                    Text(
                            text = "@{item.title}",
                            styleId = "h1",
                            textColor = "#ffffff"
                    )
            )
    ).setStyle {
        cornerRadius = CornerRadius(radius = 8.0)
        backgroundColor = "#fb5f31"
        size = Size(width = UnitValue(140.0, UnitType.REAL), height = UnitValue(140.0, UnitType.REAL))
        margin = EdgeValue.all(10)
        padding = EdgeValue.all(10)
    }.setFlex {
        justifyContent = JustifyContent.SPACE_BETWEEN
    }
}