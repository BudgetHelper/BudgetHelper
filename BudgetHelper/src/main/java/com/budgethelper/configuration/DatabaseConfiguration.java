package com.budgethelper.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:hibernate.properties")
@EnableJpaRepositories(basePackages = {"com.budgethelper.dao"})
@EnableSpringDataWebSupport
public class DatabaseConfiguration {

    private static final String HIBERNATE_DIALECT_PROPERTY = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL_PROPERTY = "hibernate.show_sql";
    private static final String HIBERNATE_FORMAT_SQL_PROPERTY = "hibernate.format_sql";

    private final Environment environment;

    public DatabaseConfiguration(final Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource) {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
            new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.budgethelper.model");
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }

    private Properties getHibernateProperties() {
        final Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT_PROPERTY, environment.getRequiredProperty(HIBERNATE_DIALECT_PROPERTY));
        properties.put(HIBERNATE_SHOW_SQL_PROPERTY, environment.getRequiredProperty(HIBERNATE_SHOW_SQL_PROPERTY));
        properties.put(HIBERNATE_FORMAT_SQL_PROPERTY, environment.getRequiredProperty(HIBERNATE_FORMAT_SQL_PROPERTY));
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SpringLiquibase liquibase(final DataSource dataSource) {
        final SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase/db_master.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}
