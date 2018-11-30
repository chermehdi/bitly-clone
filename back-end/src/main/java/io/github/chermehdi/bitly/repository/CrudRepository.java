package io.github.chermehdi.bitly.repository;

import java.util.List;
import java.util.Optional;

/**
 * @author chermehdi
 */
public interface CrudRepository<T> {

  Optional<T> findById(Long id);

  List<T> findAll();

  T save(T t);

  T delete(Long id);
}
