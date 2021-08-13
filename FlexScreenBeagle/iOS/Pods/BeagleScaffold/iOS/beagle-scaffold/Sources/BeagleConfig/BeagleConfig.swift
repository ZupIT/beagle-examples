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
import BeagleDefaults

public class BeagleConfig: DependencyLogger {
    
    public var logger: BeagleLoggerType = BeagleLoggerDefault()
    
    static private var baseURL = "https://adopt-beagle.continuousplatform.com/scaffold"
    
    @discardableResult
    static public func start(dependencies: BeagleDependencies? = nil) -> BeagleConfig {
        let dependencyLogger = BeagleConfig()
        Beagle.dependencies = scaffoldConfig(userDependencies: dependencies, with: dependencyLogger)
        return dependencyLogger
    }

    static private func scaffoldConfig(userDependencies dependencies: BeagleDependencies?, with dependencyLogger: BeagleConfig) -> BeagleDependencies {
        
        let urlBuilder = { UrlBuilder(baseUrl: URL(string: baseURL)) }
        let networkClient = { NetworkClientDefault(dependencies: dependencyLogger) }
        let cacheManager = { CacheManagerDefault(dependencies: dependencyLogger) }
        let logger = { BeagleLoggerDefault() }
        
        guard let dependencies = dependencies else {
            let dependenciesNew = BeagleDependencies(networkClient: networkClient(), cacheManager: cacheManager(), logger: dependencyLogger.logger)
            dependenciesNew.urlBuilder = urlBuilder()
            return dependenciesNew
        }
        
        if (dependencies.logger as? BeagleLoggerProxy)?.logger == nil {
            dependencies.logger = logger()
        }
        
        if dependencies.urlBuilder.baseUrl == nil {
            dependencies.urlBuilder = urlBuilder()
        }
        
        if dependencies.networkClient == nil {
            dependencies.networkClient = networkClient()
        }
        
        if dependencies.cacheManager == nil {
            dependencies.cacheManager = cacheManager()
        }

        return dependencies
    }
}
