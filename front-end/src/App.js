import React, { Component } from 'react';
import {HomeView, LoginView } from './pages'
import { Router } from '@reach/router'
import Navigation from './components/navigation'
import SideBar, { Shader } from './components/sidebar'
import { ContentContainer } from './components/containers'
import Input from "./components/forms/Input";

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
      links: [
        {
          url: '/dashboard',
          label: 'Dashboard',
          icon: 'fas fa-chart-line'
        },
        {
          url: '/new',
          label: 'New',
          icon: 'far fa-plus-square'
        }
      ],
      isOpen: false
    }
  }
  openSidebar = () => {
    this.setState(state => {
      return {sidebar: {...state.sidebar, isOpen: true}}
    })
  }
  closeSidebar = () => {
    this.setState(state => {
      return {sidebar: {...state.sidebar, isOpen: false}}
    })
  }

  search = (text) => {
    console.log('we should be searching for this', text)
  }

  handleKey = (e) => {
    console.log('should search for term', e)
  }

  render() {
    return (
        <div className="app">
          <Navigation clickedIcon={this.openSidebar} links={this.state.navigationLinks}/>
          <SideBar
              links={this.state.sidebar.links}
              isOpen={this.state.sidebar.isOpen}
          >
            <Input placeholder="search" icon="fas fa-search" onChange={this.search} hitEnter={this.handleKey}/>
          </SideBar>
          <ContentContainer style={{margin: "0 auto"}}>
            <Router>
              <HomeView path="/"/>
              <LoginView path="/login"/>
            </Router>
          </ContentContainer>
          <Shader
              isShowing={this.state.sidebar.isOpen}
              dispose={this.closeSidebar}/>
        </div>
    );
  }
}

export default App;
