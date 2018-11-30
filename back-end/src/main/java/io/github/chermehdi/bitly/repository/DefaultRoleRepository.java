package io.github.chermehdi.bitly.repository;

import io.github.chermehdi.bitly.domain.Role;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author chermehdi
 */
@Stateless
public class DefaultRoleRepository implements RoleRepository {

  @PersistenceContext
  EntityManager em;

  @Override
  public Optional<Role> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<Role> findAll() {
    return null;
  }

  @Override
  public Role save(Role role) {
    em.persist(role);
    return role;
  }

  @Override
  public Role delete(Long id) {
    return null;
  }
}
