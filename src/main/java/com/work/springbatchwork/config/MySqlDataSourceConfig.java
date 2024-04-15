package com.work.springbatchwork.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.work.springbatchwork.repository.mysql", entityManagerFactoryRef = "mysqlEntityManagerFactory")
@EntityScan(basePackages = "com.work.springbatchwork.entity.mysql")
public class MySqlDataSourceConfig {

    @Autowired
    @Qualifier("mysqlDatasource")
    private DataSource mysqlDataSource;

    @Autowired
    private EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean fac = entityManagerFactoryBuilder
                .dataSource(mysqlDataSource)
                .packages("com.work.springbatchwork.entity.mysql")
                .persistenceUnit("mysql")
                .build();

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); // Replace with your dialect
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "true");
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        fac.setJpaProperties(jpaProperties);

        return fac;
    }

}
