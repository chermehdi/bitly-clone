package io.github.chermehdi.bitly.service;

import io.github.chermehdi.bitly.domain.User;
import io.github.chermehdi.bitly.repository.UserRepository;
import io.github.chermehdi.bitly.service.exceptions.JwtSecurityException;
import java.util.Optional;
import javax.inject.Inject;

/**
 * @author chermehdi
 */
public class AuthenticationService {

  @Inject
  UserRepository userRepository;

  public Optional<User> login(String email, String password) {
    Optional<User> foundUser = userRepository.findByEmail(email);
    if (foundUser.isPresent()) {
      User user = foundUser.get();
      if (user.getPassword().equals(password)) {
        return Optional.of(user);
      }
    }
    throw new JwtSecurityException("user not found");
  }
}

