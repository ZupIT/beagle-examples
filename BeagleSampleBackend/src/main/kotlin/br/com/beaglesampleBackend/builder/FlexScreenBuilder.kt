package com.example.bffsampleflex.builder

import br.com.beaglesampleBackend.constants.*
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.ext.setFlex
import br.com.zup.beagle.ext.setStyle
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.Text

object FlexScreenBuilder: ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                navigationBar = NavigationBar(title = "Flex"),
                child = ScrollView(
                        children = listOf(
                                redContainer(),
                                yellowContainer(),
                                purpleContainer(),
                                brown(),
                                greenContainer()
                        )
                )
        )
    }

    private fun createText(text: String, styleId: String) = Text(
            text = text,
            styleId = styleId,
            alignment = TextAlignment.CENTER
    )

    private fun redContainer() = Container(
            children = listOf(
                    createText(
                            text = "1",
                            styleId = TEXT_WHITE_LARGE
                    ).setStyle {
                        backgroundColor = RED_DARK
                        size = Size(width = UnitValue.percent(100), height = UnitValue.real(220))
                    },
                    createText(
                            text = "2",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = RED_LIGHT
                        size = Size(width = UnitValue.real(50), height = UnitValue.real(50))
                        margin = EdgeValue.only(top = 16, left = 16)
                        positionType = PositionType.ABSOLUTE
                    },
                    createText(
                            text = "3",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = RED_LIGHT
                        size = Size(width = UnitValue.real(50), height = UnitValue.real(50))
                        margin = EdgeValue.only(top = 16, right = 16)
                        position = EdgeValue.only(right = 0, top = 0)
                        positionType = PositionType.ABSOLUTE
                    }
            )
    )

    private fun yellowContainer() = Container(
            children = listOf(
                    blueContainer(),
                    grayContainer(),
                    pinkContainer()
            )
    ).setStyle {
        position = EdgeValue.only(top = -25)
        size = Size(width = UnitValue.percent(100))
    }.setFlex {
        flexDirection = FlexDirection.ROW
    }

    private fun blueContainer() = Container(
            children = listOf(
                    createText(
                            text = "6",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = BLUE
                        size = Size(width = UnitValue.real(144), height = UnitValue.real(200))
                    },
                    createText(
                            text = "7",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = BLUE
                        margin = EdgeValue.only(top = 5)
                        size = Size(width = UnitValue.real(144), height = UnitValue.real(40))
                    }
            )
    ).setStyle {
        size = Size(height = UnitValue.real(245))
        position = EdgeValue.only(top = -15)
        margin = EdgeValue.only(left = 16)
    }

    private fun grayContainer() = Container(
            children = listOf(
                    createText(
                            text = "4",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = GRAY
                        margin = EdgeValue.only(right = 16)
                        size = Size(width = UnitValue.real(50), height = UnitValue.real(50))
                    },
                    createText(
                            text = "5",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = GRAY
                        margin = EdgeValue.only(right = 16)
                        size = Size(width = UnitValue.real(50), height = UnitValue.real(50))
                    }
            )
    ).setStyle {
        position = EdgeValue.only(right = 0)
        positionType = PositionType.ABSOLUTE
    }.setFlex {
        flexDirection = FlexDirection.ROW
    }

    private fun pinkContainer() = Container(
            children = listOf(
                    createText(
                            text = "8",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = PINK
                        margin = EdgeValue.only(bottom = 5)
                        size = Size(height = UnitValue.real(40))
                    },
                    createText(
                            text = "9",
                            styleId = TEXT_WHITE_DEFAULT
                    ).setStyle {
                        backgroundColor = PINK
                        margin = EdgeValue.only(bottom = 5)
                        size = Size(height = UnitValue.real(20))
                    },
                    createText(
                            text = "10",
                            styleId = TEXT_WHITE_DEFAULT
                    ).setStyle {
                        backgroundColor = PINK
                        margin = EdgeValue.only(bottom = 5)
                        size = Size(height = UnitValue.real(20))
                    },
                    createText(
                            text = "11",
                            styleId = TEXT_WHITE_DEFAULT
                    ).setStyle {
                        backgroundColor = PINK
                        margin = EdgeValue.only(bottom = 5)
                        size = Size(height = UnitValue.real(20))
                    }
            )
    ).setStyle {
        position = EdgeValue.Companion.only(top = 80)
        margin = EdgeValue.horizontal(horizontal = 16)
    }.setFlex {
        grow = 1.0
    }

    private fun purpleContainer() = Container(
            children = listOf(
                    createText(
                            text = "12",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = PURPLE
                        margin = EdgeValue.horizontal(horizontal = 16)
                        size = Size(height = UnitValue.real(50))
                    },
                    createText(
                            text = "13",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = PURPLE
                        margin = EdgeValue.only(left = 16, right = 16, top = 5)
                        size = Size(height = UnitValue.real(30))
                    },
                    createText(
                            text = "14",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = PURPLE
                        margin = EdgeValue.only(left = 16, right = 16, top = 5)
                        size = Size(height = UnitValue.real(30))
                    }
            )
    ).setStyle {
        position = EdgeValue.only(top = -25)
        margin = EdgeValue.only(top = 16)
        size = Size(width = UnitValue.percent(100))
    }

    private fun brown() = createText(
            text = "15", styleId = TEXT_WHITE_MEDIUM
    ).setStyle {
        backgroundColor = BROWN
        size = Size(height = UnitValue.Companion.real(100), width = UnitValue.Companion.percent(100))
    }

    private fun greenContainer() = Container(
            children = listOf(
                    createText(
                            text = "16",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = GREEN
                        size = Size(height = UnitValue.real(50), width = UnitValue.real(50))
                    },
                    createText(
                            text = "17",
                            styleId = TEXT_WHITE_MEDIUM
                    ).setStyle {
                        backgroundColor = GREEN
                        size = Size(height = UnitValue.real(50), width = UnitValue.real(50))
                    }
            )
    ).setStyle {
        margin = EdgeValue.only(top = 30, bottom = 16)
        size = Size(width = UnitValue.real(200))
    }.setFlex {
        flexDirection = FlexDirection.ROW
        justifyContent = JustifyContent.SPACE_BETWEEN
        alignSelf = AlignSelf.CENTER
    }



}