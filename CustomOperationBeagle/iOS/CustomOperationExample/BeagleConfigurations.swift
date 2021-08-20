/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import Foundation
import Beagle
import BeagleScaffold

struct BeagleConfigurations {
    
    static func setup() {
        let dependencies = BeagleDependencies()
        dependencies.urlBuilder = UrlBuilder(baseUrl: URL(string: "http://localhost:8080"))
        BeagleConfigurations.registerOperations(dependencies: dependencies)
        BeagleConfig.start(dependencies: dependencies)
    }
    
    static func registerOperations(dependencies: BeagleDependencies) {
        dependencies.operationsProvider.register(operationId: "isValidPassword", handler: isValidPassword())
    }
    
    static func isValidPassword() -> OperationHandler {
        return { parameters in
            guard parameters.count == 1,
                  case .string(let password) = parameters[0]
            else { return nil }
            let regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$"
            return password.range(of: regex, options: .regularExpression) != nil ? true : false
        }
    }
    
}
