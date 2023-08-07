package com.github.vaatech.moneywise.migrator.config.db;

import com.github.vaatech.moneywise.migrator.util.repository.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.github.vaatech.moneywise.migrator",
    repositoryBaseClass = BaseRepositoryImpl.class)
public class JPAConfiguration {}
