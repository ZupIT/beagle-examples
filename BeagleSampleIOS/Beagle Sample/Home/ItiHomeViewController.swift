//
//  ItiHomeViewController.swift
//  Beagle Sample
//
//  Created by Lucas Cesar on 05/01/21.
//  Copyright © 2021 ZUP IT Soluções em Informática LTDA. All rights reserved.
//

import UIKit
import Beagle

final class ItiHomeViewController: UIViewController, DeeplinkScreen {
    
    init(path: String, data: [String: String]?) {
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func screenController() -> UIViewController {
       self
    }
    
    @IBOutlet weak var headerView: UIView!
    @IBOutlet weak var logoImage: UIImageView!
    @IBOutlet weak var viewProfile: UIView!

    override func viewDidLoad() {
        super.viewDidLoad()
        navigationController?.navigationBar.isHidden = true
        applyHeaderStyle()
    }
    
    private func applyHeaderStyle() {
        logoImage.clipsToBounds = true
        logoImage.layer.cornerRadius = 35
        headerView.clipsToBounds = true
        headerView.layer.cornerRadius = 50
        headerView.layer.maskedCorners = [.layerMinXMaxYCorner]
    }
    
}
