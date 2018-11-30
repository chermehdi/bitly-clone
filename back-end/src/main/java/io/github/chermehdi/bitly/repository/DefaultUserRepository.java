package io.github.chermehdi.bitly.repository;

import io.github.chermehdi.bitly.domain.User;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author chermehdi
 */
//@Stateless
public class DefaultUserRepository implements UserRepository {

  @PersistenceContext
  EntityManager em;

  @Override
  public Optional<User> findById(Long id) {
    return Optional.ofNullable(em.find(User.class, id));
  }

  @Override
  public List<User> findAll() {
    TypedQuery<User> userQuery = em.createQuery("SELECT u from User u", User.class);
    return userQuery.getResultList();
  }

  @Override
  public User save(User user) {
    return em.merge(user);
  }

  @Override
  public User delete(Long id) {
    findById(id).map(user -> {
      em.remove(em.merge(user));
      return user;
    });
    return null;
  }

  @Override
  public Optional<User> findByEmail(String email) {
    TypedQuery<User> query = em
        .createQuery("SELECT u from User u WHERE u.email = :email", User.class);
    query.setParameter("email", email);
    User user = query.getSingleResult();
    return Optional.ofNullable(user);
  }
}
