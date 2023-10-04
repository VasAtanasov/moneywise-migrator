package com.github.vaatech.migrator.util.migrationmanager;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(Flyway.class)
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
