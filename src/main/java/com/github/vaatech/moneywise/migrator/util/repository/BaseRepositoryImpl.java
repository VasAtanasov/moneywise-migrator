package com.github.vaatech.moneywise.migrator.util.repository;

import jakarta.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.AbstractSharedSessionContract;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
    implements BaseRepository<T, ID> {
  private final EntityManager entityManager;
  private final JpaEntityInformation<T, ?> entityInformation;

  public BaseRepositoryImpl(
      JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityInformation = entityInformation;
    this.entityManager = entityManager;
  }

  @Override
  public EntityManager getEntityManager() {
    return this.entityManager;
  }

  @Override
  public Class<T> getDomainClass() {
    return entityInformation.getJavaType();
  }

  @Transactional
  public <S extends T> S persist(S entity) {
    entityManager.persist(entity);
    return entity;
  }

  @Transactional
  public <S extends T> S persistAndFlush(S entity) {
    persist(entity);
    entityManager.flush();
    return entity;
  }

  @Transactional
  public <S extends T> List<S> persistAll(Iterable<S> entities) {
    List<S> result = new ArrayList<>();
    for (S entity : entities) {
      result.add(persist(entity));
    }
    return result;
  }

  @Transactional
  public <S extends T> List<S> persistAllAndFlush(Iterable<S> entities) {
    return executeBatch(
        () -> {
          List<S> result = new ArrayList<>();
          for (S entity : entities) {
            result.add(persist(entity));
          }
          entityManager.flush();
          return result;
        });
  }

  @Transactional
  public <S extends T> S merge(S entity) {
    return entityManager.merge(entity);
  }

  @Transactional
  public <S extends T> S mergeAndFlush(S entity) {
    S result = merge(entity);
    entityManager.flush();
    return result;
  }

  @Transactional
  public <S extends T> List<S> mergeAll(Iterable<S> entities) {
    List<S> result = new ArrayList<>();
    for (S entity : entities) {
      result.add(merge(entity));
    }
    return result;
  }

  @Transactional
  public <S extends T> List<S> mergeAllAndFlush(Iterable<S> entities) {
    return executeBatch(
        () -> {
          List<S> result = new ArrayList<>();
          for (S entity : entities) {
            result.add(merge(entity));
          }
          entityManager.flush();
          return result;
        });
  }

  @Transactional
  public <S extends T> S update(S entity) {
    session().update(entity);
    return entity;
  }

  @Transactional
  public <S extends T> S updateAndFlush(S entity) {
    update(entity);
    entityManager.flush();
    return entity;
  }

  @Transactional
  public <S extends T> List<S> updateAll(Iterable<S> entities) {
    List<S> result = new ArrayList<>();
    for (S entity : entities) {
      result.add(update(entity));
    }
    return result;
  }

  @Transactional
  public <S extends T> List<S> updateAllAndFlush(Iterable<S> entities) {
    return executeBatch(
        () -> {
          List<S> result = new ArrayList<>();
          for (S entity : entities) {
            result.add(update(entity));
          }
          entityManager.flush();
          return result;
        });
  }

  protected Integer getBatchSize(Session session) {
    SessionFactoryImplementor sessionFactory =
        session.getSessionFactory().unwrap(SessionFactoryImplementor.class);
    final JdbcServices jdbcServices =
        sessionFactory.getServiceRegistry().getService(JdbcServices.class);
    if (!jdbcServices.getExtractedMetaDataSupport().supportsBatchUpdates()) {
      return Integer.MIN_VALUE;
    }
    return session.unwrap(AbstractSharedSessionContract.class).getConfiguredJdbcBatchSize();
  }

  protected <R> R executeBatch(Supplier<R> callback) {
    Session session = session();
    Integer jdbcBatchSize = getBatchSize(session);
    Integer originalSessionBatchSize = session.getJdbcBatchSize();
    try {
      if (jdbcBatchSize == null) {
        session.setJdbcBatchSize(10);
      }
      return callback.get();
    } finally {
      session.setJdbcBatchSize(originalSessionBatchSize);
    }
  }

  protected Session session() {
    return entityManager.unwrap(Session.class);
  }
}
