import React from 'react'
import './containers.css'

export default (props) => {
  const {children, ...rest} = props
  return (
    <div className="container content__container" {...rest}>
      {children}
    </div>
  )
}
