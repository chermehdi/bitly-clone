class AuthService {

  constructor() {
  }

  login(userInfo = {}) {
    console.log('auth service user info', userInfo)
  }
}

export default new AuthService()