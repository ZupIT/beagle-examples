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
        let deepLinkHandler = registerDeepLink()
        
        BeagleConfig.setAppTheme(in: dependencies)
        let innerDependencies = InnerDependencies()
        dependencies.deepLinkHandler = deepLinkHandler
        dependencies.networkClient = NetworkClientDefault(dependencies: innerDependencies)
        dependencies.cacheManager = CacheManagerDefault(dependencies: innerDependencies)
        dependencies.logger = innerDependencies.logger
        dependencies.urlBuilder = UrlBuilder(baseUrl: URL(string: "http://localhost:8080"))
        
        registerCustomComponents(in: dependencies)
        
        Beagle.dependencies = dependencies
    }
    
    private static func registerCustomComponents(in dependencies: BeagleDependencies) {
        
    }
    
    private static func registerDeepLink() -> DeeplinkScreenManager {
        let deepLink = DeeplinkScreenManager.shared
        deepLink["screen-native"] = ItiHomeViewController.self
        return deepLink
    }
    
    static func setAppTheme(in dependencies: BeagleDependencies) {
        let theme = AppTheme(styles: [
            "TextStyle": BeagleStyles.textStyle,
            "button": BeagleStyles.designSystemButton
        ])
        
        dependencies.theme = theme
    }

}

class InnerDependencies: DependencyLogger {
    var logger: BeagleLoggerType = BeagleLoggerDefault()
}
