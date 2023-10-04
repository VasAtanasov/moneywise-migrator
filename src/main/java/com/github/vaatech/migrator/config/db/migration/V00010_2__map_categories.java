package com.github.vaatech.migrator.config.db.migration;

import com.github.vaatech.migrator.moneywise.migrations.category.MWCategoryRepository;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.util.Lazy;
import org.springframework.stereotype.Component;

@Component
public class V00010_2__map_categories extends BaseJavaMigration implements ApplicationContextAware {

  private Lazy<MWCategoryRepository> categoryRepository;
  private ApplicationContext context;

  @Override
  public void migrate(Context context) throws Exception {
    var repository = categoryRepository.get();
    var categories = repository.fetchAllWithSubCategories();
    int a = 5;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
    this.categoryRepository = Lazy.of(() -> applicationContext.getBean("MWCategoryRepository", MWCategoryRepository.class));
  }
}
