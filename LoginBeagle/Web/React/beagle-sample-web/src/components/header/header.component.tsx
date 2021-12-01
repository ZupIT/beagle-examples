import React from 'react'
import { withRouter, useLocation } from 'react-router-dom'
import './header.styles.scss'


const HeaderComponent = ({history}: any) => {
  const location = useLocation()

  return (
    <div className="header">
      <img className="header-icon" src="/assets/logo-iti.png" alt="" />
      {location.pathname != '/' &&
      <span className="header-logout" onClick={()=>history.push('/')}>Sair</span>
      }
    </div>
  )

}


export default withRouter(HeaderComponent)