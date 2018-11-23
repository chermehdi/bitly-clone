import React, { Component } from 'react'

export default class HomeView extends Component {
  render() {
    return (
      <div>
        <h1> Hello MQL </h1>
        <button onClick={this.props.onClick}>toggle sidebar</button>
      </div>
    )
  }
}
