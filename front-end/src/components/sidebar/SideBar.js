import React from 'react'
import './sidebar.css'

export default (props) => {
  const { links, isOpen, ...rest } = props
  return (
    <div className={`sidebar__container ${isOpen ? 'open': ''}`}>
      <a  className="sidebar__link" href="/">
        <div>
         Home
        </div>
      </a>
      <a  className="sidebar__link" href="/">
        <div>
         Home
        </div>
      </a>
    </div>
  )
}
