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
        return self
    }
    
    @IBOutlet weak var headerView: UIView!
    @IBOutlet weak var logoImage: UIImageView!
    @IBOutlet weak var viewProfile: UIView!

    override func viewDidLoad() {
        super.viewDidLoad()
        navigationController?.navigationBar.isHidden = true
        applyHeaderStyle()
        view.addSubview(beagleView)
        beagleView.anchor(
            top: viewProfile.bottomAnchor,
            left: view.leftAnchor,
            right: view.rightAnchor,
            topConstant: 10
        )
    }
    
    private func applyHeaderStyle() {
        logoImage.clipsToBounds = true
        logoImage.layer.cornerRadius = 35
        headerView.clipsToBounds = true
        headerView.layer.cornerRadius = 50
        headerView.layer.maskedCorners = [.layerMinXMaxYCorner]
    }
    
    private lazy var beagleView: BeagleView = {
        return BeagleView(.remote(.init(url: "/carousel-options")))
    }()
    
}
