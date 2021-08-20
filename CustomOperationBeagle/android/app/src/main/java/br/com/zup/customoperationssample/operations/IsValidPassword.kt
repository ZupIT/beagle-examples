package br.com.zup.customoperationssample.operations

import br.com.zup.beagle.android.operation.Operation
import br.com.zup.beagle.android.operation.OperationType
import br.com.zup.beagle.annotation.RegisterOperation

@RegisterOperation(name = "isValidPassword")
class IsValidPassword : Operation {
    override fun execute(vararg params: OperationType?): OperationType {
        var isValidPassword: Boolean
        try {
            isValidPassword = (params[0]?.value as String)
                .matches(
                    Regex(
                        "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$"
                    )
                )

        } catch (e: Exception) {
            isValidPassword = false
        }

        return OperationType.TypeBoolean(isValidPassword)
    }
}