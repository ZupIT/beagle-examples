package br.com.beaglesampleBackend.action

import br.com.zup.beagle.annotation.RegisterAction
import br.com.zup.beagle.widget.action.Action

@RegisterAction
data class AuthenticationAction (
    val success: List<Action>,
    val error: List<Action>
    ): Action