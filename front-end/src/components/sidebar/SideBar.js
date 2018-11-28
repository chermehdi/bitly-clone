import React from 'react'
import { Link } from '@reach/router'
import Icon from '../buttons/Icon'
import './sidebar.css'

export default (props) => {
  const {links, isOpen, children, ...rest} = props
  const sidebarLinks = links.map(link =>
      (<Link key={link.url} className="sidebar__link" to={link.url}>
        <div><Icon icon={link.icon} className="icon"/>{link.label}</div>
      </Link>))
  return (
      <div className={`sidebar__container ${isOpen ? 'open' : ''}`} {...rest}>
        {sidebarLinks}
        {children}
      </div>
  )
}