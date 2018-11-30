import React from 'react'
import { ContentCard } from '../components/cards'
import { Input } from '../components/forms'
import { Button } from '../components/buttons'
import { AuthService } from '../service'

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

export default class SignupView extends React.Component {
  state = {
    email: '',
    password: '',
    firstName: '',
    lastName: ''
  }
  handleFirstNameChange = (e) => {
    this.setState({firstName: e})
  }
  handleLastNameChange = (e) => {
    this.setState({lastName: e})
  }
  handleEmailChange = (e) => {
    this.setState({email: e})
  }
  handlePasswordChange = (e) => {
    this.setState({password: e})
  }

  login = (e) => {
    e.preventDefault()
    console.log('submit ', this.state)
  }

  render() {
    return (
        <div className="form__container" style={styles.form}>
          <h1>Login Information</h1>
          <ContentCard>
            <form onSubmit={this.login}>
              <Input holderText="First Name : " onChange={this.handleFirstNameChange}/>
              <Input holderText="Last Name : " onChange={this.handleLastNameChange}/>
              <Input holderText="Email : " onChange={this.handleEmailChange}/>
              <Input holderText="Password : " onChange={this.handlePasswordChange} password/>
              <div style={styles.submit}>
                <Button type="submit" label="Submit"/>
              </div>
            </form>
          </ContentCard>
        </div>
    );
  }
}