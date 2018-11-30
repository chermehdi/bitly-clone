package io.github.chermehdi.bitly;

import io.github.chermehdi.bitly.domain.Role;
import io.github.chermehdi.bitly.domain.User;
import io.github.chermehdi.bitly.repository.RoleRepository;
import io.github.chermehdi.bitly.repository.UserRepository;
import java.util.Arrays;
import java.util.HashSet;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * @author chermehdi
 */
@Singleton
@Startup
public class DatabaseSeeder {

  @Inject
  UserRepository userRepository;

  @Inject
  RoleRepository roleRepository;


  @PostConstruct
  void init() {
    Role userRole = new Role("USER");
    Role admin = new Role("ADMIN");
    roleRepository.save(userRole);
    roleRepository.save(admin);
    User user = new User();
    user.setEmail("mehdi.cheracher@gmail.com");
    user.setPassword("123123");
    user.setActive(true);
    user.setRoles(new HashSet<>(Arrays.asList(userRole, admin)));
    userRepository.save(user);
  }
}
