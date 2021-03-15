//
//  DeeplinkScreenManager.swift
//  Beagle Sample
//
//  Created by Luis Gustavo Oliveira Silva on 06/01/21.
//  Copyright © 2021 ZUP IT Soluções em Informática LTDA. All rights reserved.
//

import UIKit
import Beagle

protocol DeeplinkScreen {
    init(path: String, data: [String: String]?)
    func screenController() -> UIViewController
}

final class DeeplinkScreenManager: DeepLinkScreenManaging {
    
    public static let shared = DeeplinkScreenManager()
    
    private var screens: [String: DeeplinkScreen.Type] = [:]
    
    public subscript(path: String) -> DeeplinkScreen.Type? {
        get {
            return screens[path]
        }
        set {
            screens[path] = newValue
        }
    }
    
    func getNativeScreen(with path: String, data: [String: String]?) throws -> UIViewController {
        guard let screenType = self[path] else {
            throw NSError(domain: "DeeplinkScreenManager", code: 1, userInfo: nil)
        }
        return screenType.init(path: path, data: data).screenController()
    }
}
