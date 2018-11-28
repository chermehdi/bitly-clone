import React from 'react'
import { Link } from "@reach/router";
import './buttons.css'

export default (props) => {
  const {to, label, onClick, ...rest} = props
  return (
      <Link to={to} onClick={onClick} className="button button__simple" {...rest}>{label}</Link>
  )
}
