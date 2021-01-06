package br.com.beaglesampleBackend.builder

import br.com.zup.beagle.builder.widget.edgeValue
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Condition
import br.com.zup.beagle.widget.action.RequestActionMethod
import br.com.zup.beagle.widget.action.SendRequest
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.ListView
import br.com.zup.beagle.widget.ui.Text

object HomeCarouselOptions {
    fun build() = Container(
            children = listOf(
                    value(),
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
                            template = template()
                    ).applyStyle(style = Style(size = Size(width = 100.unitPercent())))
            )
    )

    private fun template() = Container(
            listOf(
                    Image(
                            ImagePath.Remote(remoteUrl = "@{item.icon}")
                    ).applyStyle(
                            style = Style(
                                    size = Size(width = 40.unitReal(), height = 40.unitReal()),
                                    flex = Flex(alignSelf = AlignSelf.FLEX_END)
                            )
                    ),
                    Text(
                            text = "@{item.title}",
                            styleId = "h1",
                            textColor = "#d3d3d3"
                    )
            )
    ).applyStyle(
            style = Style(
                    cornerRadius = CornerRadius(radius = 8.0),
                    backgroundColor = "#fb5f31",
                    size = Size(width = 140.unitReal(), height = 140.unitReal()),
                    margin = EdgeValue(all = 10.unitReal()),
                    padding = EdgeValue(all = 10.unitReal()),
                    flex = Flex(justifyContent = JustifyContent.SPACE_BETWEEN)
            )
    )

    private fun value() = Container(
            context = ContextData(
                    id = "iti",
                    value = ContextIti(
                            isVisible = true,
                            balance = ""
                    )
            ),
            onInit = listOf(
                    SendRequest(
                            url = "https://private-93ff3-beagleworkshop.apiary-mock.com/value",
                            method = RequestActionMethod.GET,
                            onSuccess = listOf(
                                    SetContext(
                                            contextId = "iti",
                                            value = "@{onSuccess.data.value}"
                                    )
                            )
                    )
            ),
            children = listOf(
                    Text(
                            text = "o seu saldo é",
                            styleId = "h1",
                            textColor = "#d3d3d3"
                    ),
                    Container(
                            children = listOf(
                                    Text(
                                            text = "R$ 500,00",
                                            styleId = "h1",
                                            textColor = "#d3d3d3"
                                    ).applyStyle(style = Style(
                                            display = expressionOf("@{condition(iti.isVisible, 'FLEX', 'NONE')}")
                                    )
                                    ),
                                    Container(
                                            children = listOf(

                                            )
                                    ).applyStyle(style = Style(
                                            backgroundColor = "#FFFFFF",
                                            size = Size(width = 80.unitReal(), height = 3.unitReal()),
                                            flex = Flex(alignSelf = AlignSelf.CENTER),
                                            display = expressionOf("@{condition(iti.isVisible, 'NONE', 'FLEX')}")
                                    )),
                                    Touchable(
                                            child = Image(
                                                    ImagePath.Remote(remoteUrl = "@{condition(iti.isVisible, '/icons-iti/privado.png', '/icons-iti/visao.png')}")
                                            ).applyStyle(
                                                    style = Style(
                                                            size = Size(width = 15.unitReal(), height = 15.unitReal()),
                                                            margin = EdgeValue(left = 5.unitReal())
                                                    )
                                            ),
                                            onPress = listOf(
                                                    Condition(
                                                            condition = expressionOf("@{iti.isVisible}"),
                                                            onTrue = listOf(
                                                                SetContext(
                                                                        contextId = "iti",
                                                                        path = "isVisible",
                                                                        value = false
                                                                )
                                                            ),
                                                            onFalse = listOf(
                                                                    SetContext(
                                                                            contextId = "iti" ,
                                                                            path = "isVisible",
                                                                            value = true
                                                                    )
                                                            )
                                                    )
                                            )
                                    ),
                                    Image(
                                            ImagePath.Remote(remoteUrl = "/icons-iti/next-arrow.png")
                                    ).applyStyle(
                                            style = Style(
                                                    size = Size(width = 10.unitReal(), height = 10.unitReal()),
                                                    positionType = PositionType.ABSOLUTE,
                                                    position = EdgeValue(bottom = 2.unitReal(), right = 10.unitReal())
                                            )
                                    )
                            )
                    ).applyStyle(
                            style = Style(
                                    flex = Flex(
                                            flexDirection = FlexDirection.ROW
                                    )
                            )
                    )
            )
    ).applyStyle(
            style = Style(
                    padding = EdgeValue(left = 10.unitReal())
            )
    )
}

data class ContextIti (
        val isVisible: Boolean,
        val balance: String? = null
)