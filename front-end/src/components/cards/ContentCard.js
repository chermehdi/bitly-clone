import React from 'react'
import './cards.css'

export default (props) => {
  return (
      <div className="card__container" {...props}>
        {props.children}
      </div>
  )
}
