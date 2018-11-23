import React, { Component } from 'react';
import HomeView from './pages'
import { Router } from '@reach/router'
import Navigation from './components/navigation'

import './App.css';

class App extends Component {
  state = {
    navigationLinks: [
      {
        url: '/about',
        label: 'About'
      },
      {
        url: '/contact',
        label: 'Contact'
      }
    ]
  }
  render() {
    return (
      <div className="app">
        <Navigation links={this.state.navigationLinks} />
        <Router>
          <HomeView path="/"/>
        </Router>
      </div>
    );
  }
}

export default App;
