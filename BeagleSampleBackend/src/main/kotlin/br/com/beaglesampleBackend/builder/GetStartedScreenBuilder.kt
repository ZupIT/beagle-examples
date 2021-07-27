package br.com.beaglesampleBackend.builder

import br.com.zup.beagle.ext.setFlex
import br.com.zup.beagle.ext.setStyle
import br.com.zup.beagle.widget.action.Alert
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.*

class GetStartedScreenBuilder : ScreenBuilder {

    override fun build() = Screen(
            child = Container(
                    listOf(
                            Text(text = "Welcome to Beagle Flutter",
                                    styleId = "h1"),
                            Image(
                                    ImagePath.Remote(
                                            remoteUrl = "https://i.ibb.co/rvRN9kv/logo.png"
                                    ),
                                    ImageContentMode.FIT_CENTER
                            ).setStyle {
                                size = Size(height = UnitValue(200.00, UnitType.REAL))
                                margin = EdgeValue(top = UnitValue(50.0, UnitType.REAL),
                                        bottom = UnitValue(50.0, UnitType.REAL))
                            },
                            Text(text = "Beagle is an open source framework that helps " +
                                    "developers implement Server-Driven UI in a cross-platform way." +
                                    "\n \n",
                                    styleId = "h2"),
                            Button(
                                    text = "This is a Beagle Button - Click to navigate",
                                    onPress = listOf(
                                            Alert(
                                                    message = "This is a Beagle Alert Action" +
                                                            "\nConfirm to navigate to the next screen",
                                                    onPressOk = Navigate.OpenNativeRoute(route = "native-route")
                                            )

                                    )
                            )
                    )

            ).setFlex {
                alignItems = AlignItems.CENTER
            }.setStyle {
                margin = EdgeValue(left = UnitValue(80.0, UnitType.REAL))
            }
    )


}