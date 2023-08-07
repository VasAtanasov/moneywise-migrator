package com.github.vaatech.moneywise.migrator.config.db;

import com.github.vaatech.moneywise.migrator.util.migrationmanager.MigrationManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Slf4j
@Configuration(proxyBeanMethods = false)
public class FlywayConfiguration {

  @Bean
  public FlywayMigrationStrategy flywayMigrationStrategy() {
    return flyway -> {
      // ignore to avoid migration on startup.
      log.warn("Flyway migration on startup is skipped. Migration will be done manually.");
    };
  }

  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  public CommandLineRunner migrate(MigrationManager migrationManager) {
    return args -> {
      log.info("Flyway migration started.");
      migrationManager.migrate();
    };
  }
}
