import React from 'react'
import { Link } from '@reach/router'

import './sidebar.css'

export default (props) => {
  const {links, isOpen, ...rest} = props
  const sidebarLinks = links.map(link =>
      (<Link className="sidebar__link" to={link.to}>
        <div>{link.label}</div>
      </Link>))
  return (
      <div className={`sidebar__container ${isOpen ? 'open' : ''}`} {...rest}>
        <a className="sidebar__link" href="/">
          <div>
            Home
          </div>
        </a>
        <a className="sidebar__link" href="/">
          <div>
            Home
          </div>
        </a>
        {sidebarLinks}
      </div>
  )
}
