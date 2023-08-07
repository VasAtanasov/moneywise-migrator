package com.github.vaatech.moneywise.migrator.migrations.subcategory;

import com.github.vaatech.moneywise.migrator.util.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends BaseRepository<SubCategory, Integer> {}
