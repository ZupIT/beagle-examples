import { BeagleRemoteView } from '@zup-it/beagle-react'
import './login.styles.scss'
import React from 'react'

const LoginPage = () => {

  return (
    <div className="login-wrapper">
      <span className="login-welcome">Acesse sua conta!</span>
      <BeagleRemoteView route={'/login'}></BeagleRemoteView>
    </div>

  )

}

export default LoginPage