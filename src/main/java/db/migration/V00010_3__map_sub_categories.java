package db.migration;

import com.github.vaatech.moneywise.migrator.migrations.category.CategoryRepository;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.context.ApplicationContext;
import org.springframework.data.util.Lazy;
import org.springframework.stereotype.Component;

public class V00010_3__map_sub_categories extends BaseJavaMigration {

//
  @Override
  public void migrate(Context context) throws Exception {
//    var repo = categoryRepository.get();
//    var categories = repo.findAll();
    int a = 5;
  }
}
