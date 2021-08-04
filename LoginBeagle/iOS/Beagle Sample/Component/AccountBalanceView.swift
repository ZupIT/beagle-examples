//
//  ProfileViewController.swift
//  Beagle Sample
//
//  Created by Luis Gustavo Oliveira Silva on 06/01/21.
//  Copyright © 2021 ZUP IT Soluções em Informática LTDA. All rights reserved.
//

import Foundation
import UIKit

class AccountBalanceView: UIView {
    
    private var balanceIsHiden = false
    public var balance: String = "0,00" {
        didSet {
            labelBalance.text = "R$ \(balance)"
        }
    }
    
    init() {
        super.init(frame: .zero)
        self.setupView()
        setState()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func sizeThatFits(_ size: CGSize) -> CGSize {
        return CGSize(width: frame.width, height: 55)
    }
    
    private lazy var labelInfo: UILabel = {
        let labelInfo = UILabel()
        labelInfo.textColor = #colorLiteral(red: 1, green: 1, blue: 1, alpha: 1)
        labelInfo.text = "o seu saldo é:"
        labelInfo.font = .systemFont(ofSize: 14)
        labelInfo.numberOfLines = 0
        labelInfo.translatesAutoresizingMaskIntoConstraints = false
        return labelInfo
    }()
    
    private lazy var labelBalance: UILabel = {
        let labelBalance = UILabel()
        labelBalance.textColor = #colorLiteral(red: 1, green: 1, blue: 1, alpha: 1)
        labelBalance.text = "R$ \(balance)"
        labelBalance.font = .systemFont(ofSize: 20)
        labelBalance.numberOfLines = 0
        labelBalance.translatesAutoresizingMaskIntoConstraints = false
        return labelBalance
    }()
    
    private lazy var viewHiden: UIView = {
        let viewHiden = UIView()
        viewHiden.backgroundColor = .white
        viewHiden.layer.cornerRadius = 4
        return viewHiden
    }()
    
    private lazy var viewOptions: UIView = {
        let viewOptions = UIView()
        viewOptions.backgroundColor = .clear
        return viewOptions
    }()
    
    private lazy var imageHidenBalance: UIImageView = {
        let imageHidenBalance = UIImageView()
        let tapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(actionBalanceHiden))
        imageHidenBalance.isUserInteractionEnabled = true
        imageHidenBalance.addGestureRecognizer(tapGestureRecognizer)
        imageHidenBalance.image = UIImage(named: "visao")
        return imageHidenBalance
    }()
    
    @objc func actionBalanceHiden() {
        balanceIsHiden = !balanceIsHiden
        setState()
    }
    
    private func setState() {
        imageHidenBalance.image = balanceIsHiden ? UIImage(named: "visao") : UIImage(named: "privado")
        labelBalance.isHidden = balanceIsHiden
        viewHiden.isHidden = !balanceIsHiden
    }
    
    private func setupView() {
        addSubview(labelInfo)
        addSubview(viewOptions)
        viewOptions.addSubview(labelBalance)
        viewOptions.addSubview(viewHiden)
        addSubview(imageHidenBalance)
        
        labelInfo.anchor(
            top: topAnchor,
            left: leftAnchor,
            right: rightAnchor,
            topConstant: 5,
            leftConstant: 20,
            heightConstant: 18
        )
        
        viewOptions.anchor(
            top: labelInfo.bottomAnchor,
            left: labelInfo.leftAnchor,
            topConstant: 8,
            bottomConstant: -10,
            heightConstant: 20
        )
        
        labelBalance.anchorTo(superview: viewOptions)
        
        viewHiden.anchor(
            left: viewOptions.leftAnchor,
            right: viewOptions.rightAnchor,
            centerY: viewOptions.centerYAnchor,
            heightConstant: 4
        )
        
        imageHidenBalance.anchor(
            left: viewOptions.rightAnchor,
            centerY: viewOptions.centerYAnchor,
            leftConstant: 10,
            widthConstant: 20,
            heightConstant: 20
        )
        
    }
    
}
