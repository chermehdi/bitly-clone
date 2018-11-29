import React from 'react'
import './cards.css'
import { Button } from '../buttons'

export default (props) => {
  const {cardImage, title, onAction, style, actionLabel, ...rest} = props

  const imageStyle = {
    ...style,
    background: `url(${cardImage}) center center no-repeat`,
    backgroundSize: 'cover'
  }

  return (
      <div className="card__container" style={imageStyle} {...rest}>
        {title && <div className="card__title">{title}</div>}
        <div className="card__body">
          {props.children}
        </div>
        {onAction && <div className="card__footer">
          <Button label={actionLabel} onClick={onAction}/>
        </div>}
      </div>
  )
}
