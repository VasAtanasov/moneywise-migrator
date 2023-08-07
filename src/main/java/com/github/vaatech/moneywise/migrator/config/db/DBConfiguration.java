package com.github.vaatech.moneywise.migrator.config.db;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class DBConfiguration {

  @Bean
  JdbcConnectionDetails myJdbcConnectionDetails(DataSourceProperties properties) {
    return new JdbcConnectionDetails() {

      public String getUsername() {
        return properties.determineUsername();
      }

      public String getPassword() {
        return properties.determinePassword();
      }

      public String getJdbcUrl() {
        return properties.determineUrl();
      }
    };
  }
}
