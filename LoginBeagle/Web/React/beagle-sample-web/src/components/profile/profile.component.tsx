import React from 'react'
import './profile.styles.scss'

const ProfileComponent = () => {



  return (
    <div className="profile-wrapper">
      <span className="profile-name">João Augusto</span>
      <span className="profile-email" onClick={()=> alert('Profile click')}>Acesse aqui o seu perfil!</span>
    </div>
  )
}

export default ProfileComponent