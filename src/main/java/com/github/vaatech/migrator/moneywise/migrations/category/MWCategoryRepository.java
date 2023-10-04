package com.github.vaatech.migrator.moneywise.migrations.category;

import com.github.vaatech.migrator.util.repository.BaseRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MWCategoryRepository extends BaseRepository<MWCategory, Integer> {

  default List<MWCategory> fetchAllWithSubCategories() {
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    var query = cb.createQuery(MWCategory.class);
    var root = query.from(MWCategory.class);
    root.fetch(MWCategory_.SUB_CATEGORIES, JoinType.LEFT);
    query.select(root);
    return getEntityManager().createQuery(query).getResultList();
  }
}
