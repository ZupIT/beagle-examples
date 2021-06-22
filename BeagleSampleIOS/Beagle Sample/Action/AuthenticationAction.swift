//
//  AuthenticationAction.swift
//  Beagle Sample
//
//  Created by Luis Gustavo Oliveira Silva on 22/06/21.
//  Copyright © 2021 ZUP IT Soluções em Informática LTDA. All rights reserved.
//

import Foundation
import UIKit
import Beagle
import LocalAuthentication

struct AuthenticationAction: Action, Decodable {
    
    public let success: [Action]
    public let error: [Action]
    
        internal init(
            success: [Action],
            error: [Action]
        ) {
            self.success = success
            self.error = error
        }
    
    func execute(controller: BeagleController, origin: UIView) {
        AuthenticationManager().authenticateUser(completion: { response in
            switch response {
            case .failure:
                DispatchQueue.main.async {
                    controller.execute(actions: self.error, event: nil, origin: origin)
                }
            case .success:
                DispatchQueue.main.async {
                    controller.execute(actions: self.success, event: nil, origin: origin)
                }
            }
        })
    }
}

extension AuthenticationAction {

    enum CodingKeys: String, CodingKey {
        case success
        case error
    }

    internal init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)

        success = try container.decode(forKey: .success)
        error = try container.decode(forKey: .error)
    }
}
