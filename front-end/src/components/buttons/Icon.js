import React from 'react'

export default (props) => {
  const {icon, style, className, ...rest} = props

  const currentStyle = {
    ...IconStyle,
    ...style
  }
  const currentClassName = `${icon} ${className}`
  return (
      <i className={currentClassName} style={currentStyle} {...rest} />
  )
}

const IconStyle = {
  display: 'inline-block',
  marginRight: '.5rem'
}