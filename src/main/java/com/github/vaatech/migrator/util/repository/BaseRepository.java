package com.github.vaatech.migrator.util.repository;

import jakarta.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
  EntityManager getEntityManager();

  Class<T> getDomainClass();

  Optional<T> findById(ID id);

  boolean existsById(ID id);

  List<T> findAllById(Iterable<ID> ids);

  List<T> findAll();

  long count();

  void delete(T entity);

  T getReferenceById(ID id);

  void deleteAllInBatch(Iterable<T> entities);

  void deleteById(ID id);

  void deleteAllByIdInBatch(Iterable<ID> ids);

  void flush();

  /**
   * The persist method allows you to pass the provided entity to the {@code persist} method of the
   * underlying JPA {@code EntityManager}.
   *
   * @param entity entity to persist
   * @param <S> entity type
   * @return entity
   */
  <S extends T> S persist(S entity);

  /**
   * The persistAndFlush method allows you to pass the provided entity to the {@code persist} method
   * of the underlying JPA {@code EntityManager} and call {@code flush} afterwards.
   *
   * @param entity entity to persist
   * @param <S> entity type
   * @return entity
   */
  <S extends T> S persistAndFlush(S entity);

  /**
   * The persistAll method allows you to pass the provided entities to the {@code persist} method of
   * the underlying JPA {@code EntityManager}.
   *
   * @param entities entities to persist
   * @param <S> entity type
   * @return entities
   */
  <S extends T> List<S> persistAll(Iterable<S> entities);

  /**
   * The persistAll method allows you to pass the provided entities to the {@code persist} method of
   * the underlying JPA {@code EntityManager} and call {@code flush} afterwards.
   *
   * @param entities entities to persist
   * @param <S> entity type
   * @return entities
   */
  <S extends T> List<S> persistAllAndFlush(Iterable<S> entities);

  /**
   * The persist method allows you to pass the provided entity to the {@code merge} method of the
   * underlying JPA {@code EntityManager}.
   *
   * @param entity entity to merge
   * @param <S> entity type
   * @return entity
   */
  <S extends T> S merge(S entity);

  /**
   * The mergeAndFlush method allows you to pass the provided entity to the {@code merge} method of
   * the underlying JPA {@code EntityManager} and call {@code flush} afterwards.
   *
   * @param entity entity to merge
   * @param <S> entity type
   * @return entity
   */
  <S extends T> S mergeAndFlush(S entity);

  /**
   * The mergeAll method allows you to pass the provided entities to the {@code merge} method of the
   * underlying JPA {@code EntityManager}.
   *
   * @param entities entities to merge
   * @param <S> entity type
   * @return entities
   */
  <S extends T> List<S> mergeAll(Iterable<S> entities);

  /**
   * The mergeAllAndFlush method allows you to pass the provided entities to the {@code merge}
   * method of the underlying JPA {@code EntityManager} and call {@code flush} afterwards.
   *
   * @param entities entities to persist
   * @param <S> entity type
   * @return entities
   */
  <S extends T> List<S> mergeAllAndFlush(Iterable<S> entities);

  /**
   * The update method allows you to pass the provided entity to the {@code update} method of the
   * underlying JPA {@code EntityManager}.
   *
   * @param entity entity to update
   * @param <S> entity type
   * @return entity
   */
  <S extends T> S update(S entity);

  /**
   * The updateAndFlush method allows you to pass the provided entity to the {@code update} method
   * of the underlying JPA {@code EntityManager} and call {@code flush} afterwards.
   *
   * @param entity entity to update
   * @param <S> entity type
   * @return entity
   */
  <S extends T> S updateAndFlush(S entity);

  /**
   * The updateAll method allows you to pass the provided entities to the {@code update} method of
   * the underlying JPA {@code EntityManager}.
   *
   * @param entities entities to update
   * @param <S> entity type
   * @return entities
   */
  <S extends T> List<S> updateAll(Iterable<S> entities);

  /**
   * The updateAllAndFlush method allows you to pass the provided entities to the {@code update}
   * method of the underlying JPA {@code EntityManager} and call {@code flush} afterwards.
   *
   * @param entities entities to update
   * @param <S> entity type
   * @return entities
   */
  <S extends T> List<S> updateAllAndFlush(Iterable<S> entities);
}
