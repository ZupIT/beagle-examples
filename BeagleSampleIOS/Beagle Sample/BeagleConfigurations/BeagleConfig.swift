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

class BeagleConfig {
    static let dependencies = BeagleDependencies()
    static let client = NetworkClientDefault(dependencies: dependencies)
    
    private init() {}

    static func setup() {
        BeagleConfig.setAppTheme(in: dependencies)
        BeagleConfig.setNetworkClient(in: dependencies)
        let innerDependencies = InnerDependencies()
        dependencies.networkClient = NetworkClientDefault(dependencies: innerDependencies)
        dependencies.cacheManager = CacheManagerDefault(dependencies: innerDependencies)
        dependencies.logger = innerDependencies.logger
        dependencies.urlBuilder = UrlBuilder(baseUrl: URL(string: "http://localhost:8080"))
        Beagle.dependencies = dependencies
    }
    
    static private func setNetworkClient(in dependencies: BeagleDependencies) {
        client.httpRequestBuilder.additionalHeaders = ["x-circle-id":"578640d5-50af-41d4-817c-4639f80c207d"]
        dependencies.networkClient = client
    }
    
    static func setAppTheme(in dependencies: BeagleDependencies) {
        let theme = AppTheme(styles: [
            "h1" : BeagleStyles.h1
        ])
        
        dependencies.theme = theme
    }

}

class InnerDependencies: DependencyLogger {
    var logger: BeagleLoggerType = BeagleLoggerDefault()
}
