import React from 'react'
import { ContentCard } from '../components/cards'
import { Input } from '../components/forms'

export default class LoginView extends React.Component {
  state = {
    firstName: ''
  }
  handleFirstNameChange = (e) => {
    console.log('firstName ', e)
  }

  render() {
    return (
        <div className="form__container">
          <h1>Login Information</h1>
          <ContentCard>
            <form>
              <Input holderText="Enter your first Name: " onChange={this.handleFirstNameChange}/>
            </form>
          </ContentCard>
        </div>
    );
  }
}