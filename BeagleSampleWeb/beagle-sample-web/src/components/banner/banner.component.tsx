import { BeagleRemoteView } from '@zup-it/beagle-react'
import './banner.styles.scss'



const Banner = () => (
  <div className="banner-wrapper">
    <BeagleRemoteView route={'/paginated-list'}></BeagleRemoteView>
  </div>
)

export default Banner