//
//  BeagleConfigurations.swift
//  BffSampleFlex
//
//  Created by Joao Jaco Santos Abreu on 15/06/21.
//

import Foundation
import Beagle
import BeagleScaffold

struct BeagleConfigurations {
    
    static func setup() {
        let dependencies = BeagleDependencies()
        dependencies.urlBuilder = UrlBuilder(baseUrl: URL(string: "http://localhost:8080"))
        dependencies.theme = Styles.theme
        BeagleConfig.start(dependencies: dependencies)
    }
    
}
