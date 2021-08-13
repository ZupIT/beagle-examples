import { createBeagleUIService } from '@zup-it/beagle-react'
import { isValidPassword } from '../operations/validPassword'

export default createBeagleUIService({
  baseUrl: 'http://localhost:8080/',
  components: {},
  customOperations: {
    isValidPassword
  }
})