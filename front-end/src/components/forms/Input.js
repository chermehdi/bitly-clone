import React from 'react'
import Icon from '../buttons/Icon'
import './forms.css'

export default class Input extends React.Component {

  state = {
    currentText: ''
  }

  handleChange = (e) => {
    if(this.props.onChange) {
      this.props.onChange(e.target.value)
    }
    this.setState({currentText: e.target.value})
  }

  handleKey = (e) => {
    if(e.keyCode === 13) {
      if(this.props.hitEnter) {
        this.props.hitEnter(this.state.currentText)
      }
    }
  }
  render() {
    const {icon, holderText, password} = this.props
    const type = password ? 'password': 'text'

    return (
        <div className="input__container">
          <input className="text__input" type={type} onChange={this.handleChange} onKeyUp={this.handleKey} placeholder={holderText} />
            <span className="focus-border">
            	<i />
            </span>
          {icon && <Icon className="icon" icon={icon} />}
        </div>
    )
  }
}