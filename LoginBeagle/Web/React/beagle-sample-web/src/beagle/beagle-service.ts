import { createBeagleUIService } from '@zup-it/beagle-react'
import BalanceComponent from '../components/balance/balance.component'

export default createBeagleUIService({
  baseUrl: 'http://localhost:8080',
  components: {
    "custom:accountbalance": BalanceComponent,
  },
})
