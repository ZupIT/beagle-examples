//
//  AuthenticationManager.swift
//  Beagle Sample
//
//  Created by Luis Gustavo Oliveira Silva on 22/06/21.
//  Copyright © 2021 ZUP IT Soluções em Informática LTDA. All rights reserved.
//

import Foundation
import UIKit
import LocalAuthentication

enum AuthenticationError: Error {
    case General
    case NoEvaluate
}

class AuthenticationManager {
    
    let context = LAContext()
    
    func canEvaluatePolicy() -> Bool {
        return context.canEvaluatePolicy(.deviceOwnerAuthenticationWithBiometrics, error: nil)
    }
    
    func authenticateUser(completion: @escaping (Result<String, Error>) -> Void) {
        guard canEvaluatePolicy() else {
            completion( .failure(AuthenticationError.NoEvaluate) )
            return
        }
        
        let loginReason = "Log in with Biometrics"
        
        context.evaluatePolicy(.deviceOwnerAuthenticationWithBiometrics, localizedReason: loginReason) { success, error in
            if success {
                DispatchQueue.main.async {
                    completion(.success("Success"))
                }
            } else {
                if let error = error {
                    completion(.failure(error))
                }
            }
        }
    }
}
