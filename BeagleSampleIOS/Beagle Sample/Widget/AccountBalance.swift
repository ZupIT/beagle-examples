//
//  BalanceWidget.swift
//  Beagle Sample
//
//  Created by Luis Gustavo Oliveira Silva on 10/03/21.
//  Copyright © 2021 ZUP IT Soluções em Informática LTDA. All rights reserved.
//

import Foundation
import Beagle

public struct AccountBalance: Widget {
    
    public let value: Expression<String>
    public var widgetProperties: WidgetProperties
    
    public init(
        value: Expression<String>,
        widgetProperties: WidgetProperties = WidgetProperties()
    ) {
        self.value = value
        self.widgetProperties = widgetProperties
    }
    
    enum CodingKeys: String, CodingKey {
        case value
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)

        value = try container.decode(Expression<String>.self, forKey: .value)
        widgetProperties = try WidgetProperties(from: decoder)
    }
    
    public func toView(renderer: BeagleRenderer) -> UIView {
        let balanceComponent = AccountBalanceView()

        renderer.observe(value, andUpdateManyIn: balanceComponent) {
            balanceComponent.balance = $0 ?? ""
        }
        
        return balanceComponent
    }
   
}
