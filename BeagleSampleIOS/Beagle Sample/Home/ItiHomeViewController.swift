//
//  ItiHomeViewController.swift
//  Beagle Sample
//
//  Created by Lucas Cesar on 05/01/21.
//  Copyright © 2021 ZUP IT Soluções em Informática LTDA. All rights reserved.
//

import UIKit

final class ItiHomeViewController: UIViewController {
    @IBOutlet weak var headerView: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        applyHeaderStyle()
    }
    
    private func applyHeaderStyle() {
        headerView.clipsToBounds = true
        headerView.layer.cornerRadius = 50
        headerView.layer.maskedCorners = [.layerMinXMaxYCorner
        ]
    }
}
