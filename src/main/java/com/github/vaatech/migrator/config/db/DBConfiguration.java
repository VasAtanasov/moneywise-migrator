package com.github.vaatech.migrator.config.db;

import com.github.vaatech.migrator.util.repository.BaseRepositoryImpl;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Objects;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration(proxyBeanMethods = false)
public class DBConfiguration {

  @Configuration(proxyBeanMethods = false)
  @EnableTransactionManagement
  @EnableJpaRepositories(
      basePackages = "com.github.vaatech.migrator.moneymanager",
      entityManagerFactoryRef = "mmEntityManagerFactory",
      transactionManagerRef = "mmTransactionManager",
      repositoryBaseClass = BaseRepositoryImpl.class)
  public static class MoneyManagerJPAConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.mm")
    DataSourceProperties mmDataSourceProperties() {
      return new DataSourceProperties();
    }

    @Bean
    @Primary
    public HikariDataSource mmDataSource(DataSourceProperties mmDataSourceProperties) {
      return mmDataSourceProperties
          .initializeDataSourceBuilder()
          .type(HikariDataSource.class)
          .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mmEntityManagerFactory(
        @Qualifier("mmDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
      return builder
          .dataSource(dataSource)
          .packages("com.github.vaatech.migrator.moneymanager")
          .build();
    }

    @Bean
    public PlatformTransactionManager mmTransactionManager(
        @Qualifier("mmEntityManagerFactory")
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
      return new JpaTransactionManager(
          Objects.requireNonNull(entityManagerFactoryBean.getObject()));
    }
  }

  @Configuration(proxyBeanMethods = false)
  @EnableTransactionManagement
  @EnableJpaRepositories(
      basePackages = "com.github.vaatech.migrator.moneywise",
      entityManagerFactoryRef = "mwEntityManagerFactory",
      transactionManagerRef = "mwTransactionManager",
      repositoryBaseClass = BaseRepositoryImpl.class)
  public static class MoneyWiseJPAConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.mw")
    DataSourceProperties mwDataSourceProperties() {
      return new DataSourceProperties();
    }

    @Bean
    public HikariDataSource mwDataSource(DataSourceProperties mwDataSourceProperties) {
      return mwDataSourceProperties
          .initializeDataSourceBuilder()
          .type(HikariDataSource.class)
          .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mwEntityManagerFactory(
        @Qualifier("mwDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
      return builder
          .dataSource(dataSource)
          .packages("com.github.vaatech.migrator.moneywise")
          .build();
    }

    @Bean
    public PlatformTransactionManager mwTransactionManager(
        @Qualifier("mwEntityManagerFactory")
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
      return new JpaTransactionManager(
          Objects.requireNonNull(entityManagerFactoryBean.getObject()));
    }
  }

  static final class PropertiesJdbcConnectionDetails implements JdbcConnectionDetails {

    private final DataSourceProperties properties;

    PropertiesJdbcConnectionDetails(DataSourceProperties properties) {
      this.properties = properties;
    }

    @Override
    public String getUsername() {
      return this.properties.determineUsername();
    }

    @Override
    public String getPassword() {
      return this.properties.determinePassword();
    }

    @Override
    public String getJdbcUrl() {
      return this.properties.determineUrl();
    }

    @Override
    public String getDriverClassName() {
      return this.properties.determineDriverClassName();
    }

    @Override
    public String getXaDataSourceClassName() {
      return (this.properties.getXa().getDataSourceClassName() != null)
          ? this.properties.getXa().getDataSourceClassName()
          : JdbcConnectionDetails.super.getXaDataSourceClassName();
    }
  }
}
