package com.work.springbatchwork.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.work.springbatchwork.repository.h2", entityManagerFactoryRef = "h2EntityManagerFactory")
@EntityScan(basePackages = "com.work.springbatchwork.entity.h2")
public class H2DataSourceConfig {

    @Autowired
    @Qualifier("h2Datasource")
    private DataSource h2DataSource;

    @Autowired
    private EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean fac = entityManagerFactoryBuilder
                .dataSource(h2DataSource)
                .packages("com.work.springbatchwork.entity.h2")
                .persistenceUnit("h2")
                .build();

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); // Replace with your dialect
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "true");
        jpaProperties.put("hibernate.hbm2ddl.auto", "update"); // Disable automatic DDL generation
        fac.setJpaProperties(jpaProperties);
        return fac;
    }

}
