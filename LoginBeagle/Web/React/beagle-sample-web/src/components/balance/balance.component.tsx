import React, { useState } from 'react'
import "./balance.styles.scss"


interface BalanceInterface {
  value: string
}

const BalanceComponent = ({ value }: BalanceInterface) => {
  const [balanceVisible, setBalanceVisibility] = useState(false);

  function showOrHideBalance() {
    setBalanceVisibility(!balanceVisible)
  }

  return (
    <div>
      <div className="wrapper">
        <div className="balance">
          <span className="balance-text">Meu saldo:</span>
          {balanceVisible ? <span className="balance-total">R$ {value}</span> :
            <div className="hide-box"></div>
          }
        </div>
        <img
          className="balance-show-hide-icon"
          onClick={showOrHideBalance}
          src={balanceVisible ? '/assets/hide.png' : '/assets/show.png'}
          alt="" />
      </div>
      <div className="divider"></div>
    </div>

  )

}

export default BalanceComponent