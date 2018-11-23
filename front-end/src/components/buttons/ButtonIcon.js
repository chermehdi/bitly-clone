import React from 'react'
import { Link } from '@reach/router'
import './buttons.css'

export default (props) => {
  const { to, icon, alt, ...rest} = props
  return (
    <Link className="logo__button" to={to} {...rest}>
      <img src={icon} alt={alt} />
    </Link>
  )
}
