import React from 'react'
import './App.css'
import HeaderComponent from './components/header/header.component'
import MainComponent from './pages/main.component'
import { Switch, Route } from 'react-router-dom'
import LoginPage from './pages/login/login.component'
import { BeagleProvider } from '@zup-it/beagle-react'
import BeagleService from './beagle/beagle-service'

function App() {
  return (
    <>
      <HeaderComponent />
      <BeagleProvider value={BeagleService}>
        <Switch>
          <Route exact path="/screen-native" component={MainComponent}></Route>
          <Route exact path="/" component={LoginPage}></Route>
        </Switch>
      </BeagleProvider>

    </>

  )
}

export default App
