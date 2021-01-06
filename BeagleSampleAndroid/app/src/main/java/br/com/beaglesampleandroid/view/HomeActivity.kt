/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.beaglesampleandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.beaglesampleandroid.R
import br.com.zup.beagle.android.action.RequestActionMethod
import br.com.zup.beagle.android.action.SendRequest
import br.com.zup.beagle.android.action.SetContext
import br.com.zup.beagle.android.components.Image
import br.com.zup.beagle.android.components.ImagePath
import br.com.zup.beagle.android.components.Text
import br.com.zup.beagle.android.components.Touchable
import br.com.zup.beagle.android.components.layout.Container
import br.com.zup.beagle.android.context.ContextData
import br.com.zup.beagle.android.utils.loadView
import br.com.zup.beagle.android.utils.toView
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.FlexDirection
import br.com.zup.beagle.widget.core.Size
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        frame_layout.addView(cardProfile().toView(this))

        frame_layout_card.loadView(this, ScreenRequest("/carousel-options"))

    }


    private fun cardProfile(): Container{
        return Container(
            children = listOf(
                Image(ImagePath.Local(mobileId = "mobile")).applyStyle(
                    Style(
                        size = Size(width = 80.unitReal(),height = 80.unitReal())
                    )
                ),
                cardName()
            )
        ).applyStyle(
            Style(
                flex = Flex(
                    flexDirection = FlexDirection.ROW
                )
            )
        )
    }

    private fun cardName(): Container{
        return Container(
            context = ContextData(
                id = "itiName",
                value = ""
            ),
            onInit = listOf(
                SendRequest(
                    url = "https://private-93ff3-beagleworkshop.apiary-mock.com/name",
                    method = RequestActionMethod.GET,
                    onSuccess = listOf(
                        SetContext(
                            contextId = "itiName",
                            value = "@{onSuccess.data.name}"
                        )
                    )
                )
            ),
            children = listOf(
                Text(text = "@{itiName}",styleId = "TextTitleProfile").applyStyle(
                    Style(
                        margin = EdgeValue(all = 8.unitReal())
                    )
                ),
                createTouchable()

            )
        )
    }

    private fun createTouchable(): Touchable {
        return Touchable(
            child = Container(
                children = listOf(
                    Text("acessar perfil", styleId = "TextAccessProfile"),
                    Image(ImagePath.Local("right-arrow")).applyStyle(
                        Style(
                            margin = EdgeValue(horizontal = 4.unitReal())
                        )
                    )
                )
            ).applyStyle(
                Style(
                    flex = Flex(
                        flexDirection = FlexDirection.ROW
                    )
                )
            ),
            onPress = listOf(

            )
        )
    }
}