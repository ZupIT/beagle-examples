import React from 'react'
import CardComponent from '../components/card/card.component'
import BeagleService from '../beagle/beagle-service'
import { BeagleProvider } from '@zup-it/beagle-react/common/provider'
import { BeagleRemoteView } from '@zup-it/beagle-react'
import ProfileComponent from '../components/profile/profile.component'

const MainComponent = () => {
  return (
    <>
      <ProfileComponent></ProfileComponent>
      <CardComponent>
        <BeagleRemoteView route={'/carousel-options'} />
      </CardComponent>
    </>
  )
}

export default MainComponent