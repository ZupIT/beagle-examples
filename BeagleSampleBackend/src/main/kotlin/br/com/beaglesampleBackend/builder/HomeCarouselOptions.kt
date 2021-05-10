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
import br.com.zup.beagle.widget.core.AlignSelf
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.core.ListDirection
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.core.UnitType
import br.com.zup.beagle.widget.core.UnitValue
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
                    ).setStyle {
                            size = Size(width = UnitValue(100.0, UnitType.PERCENT))
                    }
            )
    )

    private fun template() = Container(
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