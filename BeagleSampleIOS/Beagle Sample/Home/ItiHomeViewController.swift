//
//  ItiHomeViewController.swift
//  Beagle Sample
//
//  Created by Lucas Cesar on 05/01/21.
//  Copyright © 2021 ZUP IT Soluções em Informática LTDA. All rights reserved.
//

import UIKit
import Beagle
import BeagleSchema

final class ItiHomeViewController: UIViewController, DeeplinkScreen {
    
    init(path: String, data: [String: String]?) {
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func screenController() -> UIViewController {
        return self
    }
    
    @IBOutlet weak var headerView: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        applyHeaderStyle()
        view.addSubview(beagleView)
        beagleView.anchor(
            top: view.topAnchor,
            left: view.leftAnchor,
            right: view.rightAnchor
        )
        
    }
    
    private func applyHeaderStyle() {
        headerView.clipsToBounds = true
        headerView.layer.cornerRadius = 50
        headerView.layer.maskedCorners = [.layerMinXMaxYCorner
        ]
    }
    
    private lazy var beagleView: BeagleView = {
        return BeagleView(.remote(.init(url: "/carousel-options")))
    }()
    
   
}
