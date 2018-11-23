import React from 'react'
import './sidebar.css'
export default (props) => {
  const { isShowing } = props 
  return (
    <div className={`shader ${isShowing ? 'open': ''}`} 
      onClick={props.dispose}>  
    </div>
  )
}
