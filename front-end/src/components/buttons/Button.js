import React from 'react'
import './buttons.css'

export default (props) => {
  const {label, onClick, ...rest} = props
  return (
      <button onClick={onClick} className="button button__simple" {...rest}>{label}</button>
  )
}
