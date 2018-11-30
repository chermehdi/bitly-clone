package io.github.chermehdi.bitly.repository;

import io.github.chermehdi.bitly.domain.User;
import java.util.Optional;

/**
 * @author chermehdi
 */
public interface UserRepository extends CrudRepository<User> {

  Optional<User> findByEmail(String email);
}
