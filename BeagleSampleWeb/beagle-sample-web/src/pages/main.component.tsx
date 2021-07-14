import CardComponent from '../components/card/card.component'
import { BeagleRemoteView } from '@zup-it/beagle-react'
import ProfileComponent from '../components/profile/profile.component'
import "./main.styles.scss"
import Banner from '../components/banner/banner.component'

const MainComponent = () => {
  return (
    <>
      <ProfileComponent></ProfileComponent>
      <div>
      <CardComponent>
        <BeagleRemoteView route={'/carousel-options'} />
      </CardComponent>
      <Banner/>
      </div>
      

    </>
  )
}

export default MainComponent