import React, { Component } from 'react';
import HomeView from './pages'
import { Router } from '@reach/router'
import Navigation from './components/navigation'
import SideBar, { Shader } from './components/sidebar'

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
    ],
    sidebar: {
      links: [],
      isOpen: false
    }
  }
  openSidebar = () => {
    this.setState({
      sidebar: {
        links: [],
        isOpen: true
      }
    })
  }
  closeSidebar = () => {
    console.log('close sidebar')
    this.setState(state => {
      return {sidebar: {...state.sidebar, isOpen: false}}
    })
  }

  render() {
    return (
        <div className="app">
          <Navigation links={this.state.navigationLinks}/>
          <SideBar
              links={this.state.sidebar.links}
              isOpen={this.state.sidebar.isOpen}
          />
          <Router>
            <HomeView path="/" onClick={this.openSidebar}/>
          </Router>
          <Shader
              isShowing={this.state.sidebar.isOpen}
              dispose={this.closeSidebar}/>
        </div>
    );
  }
}

export default App;
