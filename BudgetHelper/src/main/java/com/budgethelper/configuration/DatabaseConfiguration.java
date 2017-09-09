package com.budgethelper.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.budgethelper.model")
@PropertySource(value = "classpath:hibernate.properties")
public class DatabaseConfiguration {

	private Environment environment;

	public DatabaseConfiguration(final Environment environment) {
		this.environment = environment;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(this.datasource());
		sessionFactory.setPackagesToScan("com.budgethelper.model");
		sessionFactory.setHibernateProperties(this.getHibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource datasource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	private Properties getHibernateProperties() {
		final Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
		final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

	@Bean
	public SpringLiquibase liquibase() {
		final SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:liquibase/db_master.xml");
		liquibase.setDataSource(this.datasource());
		return liquibase;
	}
}
