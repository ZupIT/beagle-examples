package br.com.beaglesampleBackend.builder

import br.com.beaglesampleBackend.widget.AccountBalance
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.RequestActionMethod
import br.com.zup.beagle.widget.action.SendRequest
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.ListView
import br.com.zup.beagle.widget.ui.Text

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
                            textColor = "#ffffff"
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
}