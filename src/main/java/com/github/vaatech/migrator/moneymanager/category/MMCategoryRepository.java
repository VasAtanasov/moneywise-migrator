package com.github.vaatech.migrator.moneymanager.category;

import com.github.vaatech.migrator.util.repository.BaseRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MMCategoryRepository extends BaseRepository<MMCategory, Integer> {

  // Only root level categories with their subcategories
  default List<MMCategory> fetchAllWithSubCategories() {
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    var query = cb.createQuery(getDomainClass());
    var root = query.from(getDomainClass());
    root.fetch(MMCategory_.PARENT, JoinType.LEFT);
    root.fetch(MMCategory_.SUB_CATEGORIES, JoinType.LEFT);

    Predicate predicate =
        cb.and(
            cb.equal(root.get(MMCategory_.STATUS), 0),
            cb.or(
                cb.isNull(root.get(MMCategory_.IS_DELETED)),
                cb.equal(root.get(MMCategory_.IS_DELETED), false)));

    query.select(root).where(predicate);
    return getEntityManager().createQuery(query).getResultList();
  }
}
