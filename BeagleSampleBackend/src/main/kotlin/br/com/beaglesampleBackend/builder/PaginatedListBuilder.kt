package br.com.beaglesampleBackend.builder

import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.ext.setFlex
import br.com.zup.beagle.ext.setStyle
import br.com.zup.beagle.widget.action.Alert
import br.com.zup.beagle.widget.action.RequestActionMethod
import br.com.zup.beagle.widget.action.SendRequest
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.*

object PaginatedListBuilder {
    fun build() = createPaginatedList()
}

private var baseUrl = "https://gist.githubusercontent.com/hectorcustodiozup/510b0675daff4e96bf529bf3ee24887d/raw/f8a01b02efd77712a9c6ebb369c041543b81e8db/banner-page-"

class Banner(
    page: Number,
    content: Array<Any>
)


private fun createPaginatedList() = Container(
        context = ContextData(id = "promotionalAd", value = Banner(page = 0, content = arrayOf())),
        children = listOf(
                createList(),
                Container(
                        children = listOf(
                                createPreviousButton(),
                                createNextButton()
                        )
                )
                        .setFlex {
                    flexDirection = FlexDirection.ROW;
                    justifyContent= JustifyContent.SPACE_BETWEEN
                }
                        .setStyle {
                    positionType = PositionType.ABSOLUTE;
                    size = Size(width = UnitValue(100.00, UnitType.PERCENT),
                    height = UnitValue(100.00, UnitType.PERCENT))
                }

        )
).setStyle {
    positionType = PositionType.RELATIVE;
}

private fun createList() = ListView(
        dataSource = expressionOf("@{promotionalAd.content}"),
        onInit = listOf(
          requestPage(baseUrl+"1.json")
        ),
        templates = createTemplates()
)

private fun createPreviousButton()= Button(
        styleId = "paginatedButton",
        text = "<",
        onPress = listOf(
                requestPage(baseUrl+"@{subtract(promotionalAd.page, 1)}.json")
        )
).setStyle {
    size = Size(height = UnitValue(80.0, UnitType.REAL));
    borderColor = "#000000";
    position = EdgeValue(top = UnitValue(40.0, UnitType.PERCENT))
}

private fun createNextButton()= Button(
        styleId = "paginatedButton",
        text = ">",
        onPress = listOf(
                requestPage(baseUrl+"@{sum(promotionalAd.page, 1)}.json")
        )
).setStyle {
    size = Size(height = UnitValue(80.0, UnitType.REAL));
    borderColor = "#000000";
    position = EdgeValue(top = UnitValue(40.0, UnitType.PERCENT))

}

private fun createTemplates() = listOf<Template>(
        Template(
                expressionOf("@{eq(item.type, 'image')}"),
                Container(
                        children =  listOf(
                                Image(
                                        ImagePath.Remote("@{item.image.url}"),
                                        ImageContentMode.FIT_CENTER
                                ).setStyle {
                                    size = Size(height = UnitValue(100.00, UnitType.REAL))
                                }
                        )
                )
        ),
        Template(
                expressionOf("@{eq(item.type, 'text')}"),
                Container(
                        listOf(
                                Text(
                                        text = "@{item.title}"
                                ),
                                Text(
                                        text = "@{item.description}"
                                )
                        )
                )
        )
)

private fun requestPage(requestUrl:String) =
    SendRequest(
            method = RequestActionMethod.GET,
            url = requestUrl,
            onSuccess = listOf(
                    SetContext(
                            contextId = "promotionalAd",
                            value = "@{onSuccess.data}"
                    )
            )
    )
