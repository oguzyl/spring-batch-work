package com.work.springbatchwork.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class JpaConfig {

    @Bean(name = "h2Datasource")
    public DataSource h2DataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:h2:mem:testdb")
                .username("sa")
                .password("aa")
                .driverClassName("org.h2.Driver")
                .build();
    }

    @Bean(name = "mysqlDatasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:mysql://localhost:3306/social-media-database")
                .username("social-media-user")
                .password("dummypassword")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }

    @Bean(name = "h2TransactionManager")
    public PlatformTransactionManager h2TransactionManager() {
        return new DataSourceTransactionManager(h2DataSource());
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager() {
        return new DataSourceTransactionManager(mysqlDataSource());
    }

}
