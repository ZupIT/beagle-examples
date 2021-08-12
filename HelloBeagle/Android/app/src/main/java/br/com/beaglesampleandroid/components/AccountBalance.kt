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

package br.com.beaglesampleandroid.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.beaglesampleandroid.R
import br.com.beaglesampleandroid.utils.applyCurrencyFormat
import kotlinx.android.synthetic.main.account_balance.view.*

class AccountBalance constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
): ConstraintLayout(context, attrs, defStyleAttr){

    var isVisible = true

    init {
        View.inflate(context, R.layout.account_balance, this)
        initialComponent()
        invalidate()
        requestLayout()
    }

    fun setValueBalance(value: String) {
        mtv_value_balance.text = value.applyCurrencyFormat("R$ ")
    }
    fun actionBalanceHidden() {
        isVisible = !isVisible
    }

    private fun setImage() : Int {
        return if (isVisible) R.drawable.ic_vision  else R.drawable.ic_invisible
    }

    fun initialComponent() {
        visible.setOnClickListener {
            actionBalanceHidden()
            visible.setImageResource(setImage())
            if (isVisible) {
                mtv_value_balance.visibility = View.GONE
                view_invisible_value.visibility = View.VISIBLE
            } else {

                mtv_value_balance.visibility = View.VISIBLE
                view_invisible_value.visibility = View.GONE
            }
        }
    }
}