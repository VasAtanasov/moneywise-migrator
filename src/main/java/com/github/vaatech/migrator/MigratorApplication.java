package com.github.vaatech.migrator;

import com.github.vaatech.migrator.moneymanager.MMCategoryRepository;
import com.github.vaatech.migrator.moneywise.migrations.category.MWCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MigratorApplication {

  public static void main(String[] args) {
    SpringApplication.run(MigratorApplication.class, args);
  }

  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  public CommandLineRunner migrate(
      MMCategoryRepository mmCategoryRepository, MWCategoryRepository mwCategoryRepository) {
    var mwCategories = mwCategoryRepository.fetchAllWithSubCategories();
    var cat = mwCategories.get(1);
    var subCat = cat.getSubCategories();
    var mmCategories = mmCategoryRepository.findAll();
    return args -> {};
  }
}
