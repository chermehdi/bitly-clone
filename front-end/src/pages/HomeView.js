import React, { Component } from 'react'
import { ImageCard, ContentCard } from "../components/cards";
import heroImage from '../static/hero-2.jpg'
import Dashboard from '../static/dashboard.svg'
import Url from '../static/link.svg'
import Secure from '../static/secure.svg'
import { LinkButton } from '../components/buttons'


const Feature = (props) => {
  const {thumb, text, desc, ...rest} = props
  return (
      <div style={homeStyle.feature} {...rest}>
        <div style={homeStyle.featureImageContainer}>
          <img style={homeStyle.featureImage} src={thumb} alt=""/>
        </div>
        <div style={homeStyle.featureText}>
          <h3>{text}</h3>
          <p style={{fontSize: '.8rem'}}>{desc}</p>
        </div>
      </div>
  )
}

export default class HomeView extends Component {
  render() {
    return (
        <div>
          <ImageCard cardImage={heroImage} style={homeStyle.hero}>
            <h1>Bitly</h1>
            <p>The Power is in your Links, you just have to use it</p>
            <LinkButton to="/login" label="Start Now" style={{marginTop: '2rem'}}/>
          </ImageCard>
          <div style={homeStyle.features}>
            <ContentCard>
              <Feature thumb={Dashboard} text="feature" desc="this is a desc"/>
            </ContentCard>
            <ContentCard>
              <Feature thumb={Url} text="feature" desc="this is a desc"/>
            </ContentCard>
            <ContentCard>
              <Feature thumb={Secure} text="feature" desc="this is a desc"/>
            </ContentCard>
          </div>
        </div>
    )
  }
}


const homeStyle = {
  hero: {
    minHeight: '10rem',
    color: 'var(--white)',
    marginBottom: '2rem'
  },
  features: {
    display: 'grid',
    gridTemplateColumns: 'repeat( auto-fit, minmax(200px, 1fr) )',
    gridColumnGap: '1rem'
  },
  featureImageContainer: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center'
  },
  featureImage: {
    maxWidth: '11rem',
    minHeight: '13rem'
  },
  featureText: {
    textAlign: 'center'
  }
}