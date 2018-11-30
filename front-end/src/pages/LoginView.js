import React from 'react'
import { ContentCard } from '../components/cards'
import { Input } from '../components/forms'
import { Button } from '../components/buttons'

const styles = {
  submit: {
    display: 'flex',
    width: '100%',
    alignItems: 'flex-end',
    paddingTop: '1rem'
  },
  form: {
    maxWidth: '30rem',
    margin: '0 auto'
  }
}

export default class LoginView extends React.Component {
  state = {
    email: '',
    password: ''
  }
  handleEmailChange = (value) => {
    this.setState({email: value})
  }

  handlePasswordChange = (value) => {
    this.setState({password: value})
  }

  login = (event) => {
    event.preventDefault()
    // do the submit logic here !
    console.log('submit ', this.state)
  }

  render() {
    return (
        <div className="form__container" style={styles.form}>
          <h1>Login Information</h1>
          <ContentCard>
            <form onSubmit={this.login}>
              <Input holderText="Enter your Email : " onChange={this.handleEmailChange}/>
              <Input holderText="Enter your Password : " onChange={this.handlePasswordChange} password/>
              <div style={styles.submit}>
                <Button type="submit" label="Submit"/>
              </div>
            </form>
          </ContentCard>
        </div>
    );
  }
}