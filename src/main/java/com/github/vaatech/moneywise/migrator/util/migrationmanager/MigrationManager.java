package com.github.vaatech.moneywise.migrator.util.migrationmanager;

import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

@Component
public class MigrationManager {

  private final Flyway flyway;

  public MigrationManager(Flyway flyway) {
    this.flyway = flyway;
  }

  public void migrate() {
    flyway.repair();
    flyway.migrate();
  }
}
