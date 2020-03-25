package com.spring.akash.config;


import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.akash.dao.EmployeeDaoImpl;
import com.spring.akash.model.Department;
import com.spring.akash.model.Employee;

@EnableWebMvc
@EnableTransactionManagement
@Configuration
@ComponentScan("com.spring.akash")
@PropertySource("classpath:db.properties")
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DriverManagerDataSource driverManagerDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("DRIVER_CLASS"));
		ds.setUrl(env.getProperty("DB_URL"));
		ds.setUsername(env.getProperty("DB_USER"));
		ds.setPassword(env.getProperty("DB_PASS"));
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(driverManagerDataSource());
		
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		p.setProperty("hibernate.show_sql", "true");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.connection.autocommit", "true");
		sf.setHibernateProperties(p);
		
		sf.setAnnotatedClasses(Employee.class,Department.class);
		return sf;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate ht = new HibernateTemplate();
		ht.setSessionFactory(localSessionFactoryBean().getObject());
		return ht;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(localSessionFactoryBean().getObject());
		return htm;
	}
	
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	   // bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/views/");
	    bean.setSuffix(".jsp");
	    return bean;
	}

}
