// 
//  Styles.swift
//  BffSampleFlex
//
//  Created by Joao Jaco Santos Abreu on 15/06/21.
//

import UIKit
import Beagle

struct Styles {
    
    static let theme = Beagle.AppTheme(styles: [
        "DesignSystem.textWhiteLarge" : Self.whiteTextLarge,
        "DesignSystem.textWhiteMedium" : Self.whiteTextMedium,
        "DesignSystem.textWhiteDefault" : Self.whiteTextDefault
    ])
    
    static func whiteTextLarge() -> (UITextView?) -> Void {
        return BeagleStyle.text(font: .systemFont(ofSize: 40), color: .white)
    }
    
    static func whiteTextMedium() -> (UITextView?) -> Void {
        return BeagleStyle.text(font: .systemFont(ofSize: 20), color: .white)
    }
    
    static func whiteTextDefault() -> (UITextView?) -> Void {
        return BeagleStyle.text(font: .systemFont(ofSize: 16), color: .white)
    }
    
}
