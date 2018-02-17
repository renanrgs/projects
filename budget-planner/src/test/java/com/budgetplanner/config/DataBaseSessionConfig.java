package com.budgetplanner.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class DataBaseSessionConfig {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan(new String[] {
				"com.budgetplanner.domain"
		});
		Properties props = new Properties();
		props.setProperty("dialect", "org.hirbernate.dialect.H2Dialect");
		sessionFactoryBean.setHibernateProperties(props);
		return sessionFactoryBean;
	}
	
}
