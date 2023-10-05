package com.github.vaatech.migrator;

import com.github.vaatech.migrator.moneymanager.accounts.AssetGroupRepository;
import com.github.vaatech.migrator.moneymanager.accounts.AssetRepository;
import com.github.vaatech.migrator.moneymanager.category.MMCategoryRepository;
import com.github.vaatech.migrator.moneymanager.currency.MMCurrencyRepository;
import com.github.vaatech.migrator.moneymanager.transactions.MMTransactionRepository;
import com.github.vaatech.migrator.moneywise.migrations.category.MWCategoryRepository;
import com.github.vaatech.migrator.moneywise.migrations.currency.MWCurrencyRepository;
import com.github.vaatech.migrator.moneywise.migrations.transactions.MWTransactionRepository;
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
      MMCategoryRepository mmCategoryRepository,
      MWCategoryRepository mwCategoryRepository,
      AssetGroupRepository assetGroupRepository,
      AssetRepository assetRepository,
      MMCurrencyRepository mmCurrencyRepository,
      MWCurrencyRepository mwCurrencyRepository,
      MWTransactionRepository mwTransactionRepository,
      MMTransactionRepository mmTransactionRepository) {
    var mwCategories = mwCategoryRepository.fetchAllWithSubCategories();
    var cat = mwCategories.get(1);
    var subCat = cat.getSubCategories();
    var mmCategories = mmCategoryRepository.fetchAllWithSubCategories();

    var assetGroups = assetGroupRepository.findAll();
    var assets = assetRepository.findAll();
    var mmCurrency = mmCurrencyRepository.findAll();
    var mwCurrency = mwCurrencyRepository.findAll();
    var mmTransactions = mmTransactionRepository.findAll();
    var mwTransactions = mwTransactionRepository.findAll();

    int a = 5;

    return args -> {};
  }
}
