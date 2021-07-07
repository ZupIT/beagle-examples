import React from 'react'
import CardComponent from '../components/card/card.component'
import BeagleService from '../beagle/beagle-service'
import { BeagleProvider } from '@zup-it/beagle-react/common/provider'
import HeaderComponent from '../components/header/header.component'
import { BeagleRemoteView } from '@zup-it/beagle-react'
import ProfileComponent from '../components/profile/profile.component'

const MainComponent = () => {
  return (
    <BeagleProvider value={BeagleService}>
      <HeaderComponent></HeaderComponent>
      <ProfileComponent></ProfileComponent>
      <CardComponent>
        <BeagleRemoteView route={'/carousel-options'} />
      </CardComponent>
    </BeagleProvider>
  )
}

export default MainComponent