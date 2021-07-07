import { BeagleRemoteView } from '@zup-it/beagle-react';
import React from 'react';

import './card.styles.scss'

const CardComponent = ({children}:any) =>{



  return (
      <div className="card container">
        {children}
      </div>
  )
}

export default CardComponent