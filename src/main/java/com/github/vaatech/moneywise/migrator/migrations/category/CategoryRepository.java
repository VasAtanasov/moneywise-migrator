package com.github.vaatech.moneywise.migrator.migrations.category;

import com.github.vaatech.moneywise.migrator.util.repository.BaseRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Integer> {

  default List<Category> fetchAllWithSubCategories() {
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    var query = cb.createQuery(Category.class);
    var root = query.from(Category.class);
    root.fetch(Category_.SUB_CATEGORIES, JoinType.LEFT);
    query.select(root);
    return getEntityManager().createQuery(query).getResultList();
  }
}
