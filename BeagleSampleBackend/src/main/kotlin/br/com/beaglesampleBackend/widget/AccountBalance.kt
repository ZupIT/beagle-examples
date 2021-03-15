package br.com.beaglesampleBackend.widget

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.context.Bind

@RegisterWidget
class AccountBalance (
    val value: Bind<String>
): Widget()