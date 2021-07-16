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

package br.com.beaglesampleandroid.beagle

import br.com.beaglesampleandroid.R
import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.setup.DesignSystem

@BeagleComponent
class AppDesignSystem: DesignSystem() {
    override fun textStyle(id: String): Int? {
        return when(id) {
            "TextStyle" -> R.style.TextStyle
            "TextAccessProfile" -> R.style.TextAccessProfile
            "TextTitleProfile" -> R.style.TextTitleProfile
            "h1" -> R.style.TextTemplateCard
            "bannerTitle" -> R.style.DesignSystem_Text_BannerTitle
            "bannerDescription" -> R.style.DesignSystem_Text_BannerDescription
            else -> R.style.TextDefault
        }
    }

    override fun buttonStyle(id: String): Int? {
        return when(id) {
            "paginatedButton" -> R.style.DesignSystem_Button_PageBullet
            else -> R.style.DesignSystem_Button_Default
        }
    }

    override fun toolbarStyle(id: String): Int? {
        return when(id){
            "toolbar" -> R.style.DesignSystem_Toolbar_Center
            else -> R.style.DesignSystem_Toolbar_Center
        }
    }

    override fun inputTextStyle(id: String): Int? {
        return when(id) {
            "TextInput" -> R.style.TextInput
            else -> R.style.TextInput
        }
    }

    override fun image(id: String): Int? {
        return when(id) {
            "mobile" -> R.drawable.ic_launcher_foreground
            "right-arrow" -> R.drawable.ic_right_arrow
            else -> android.R.drawable.ic_menu_help
        }
    }
}