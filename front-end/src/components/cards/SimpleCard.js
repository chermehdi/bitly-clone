import React from 'react'
import './cards.css'
import { Button } from '../buttons'

export default (props) => {

  const {title, onAction, actionLabel, ...rest} = props

  return (
      <div className="card__container" {...rest}>
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
