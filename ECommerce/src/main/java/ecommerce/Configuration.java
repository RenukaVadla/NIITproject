package ecommerce;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@ComponentScan("ecommerce")
public class Configuration {
	
	@Bean
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		localSessionFactoryBuilder.addProperties(getProperties());
		localSessionFactoryBuilder.scanPackages("ecommerce");
		return localSessionFactoryBuilder.buildSessionFactory();
		
		
	}
	@Bean
	public DataSource getDataSource()
	{
		BasicDataSource dataSource =new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ecommerce");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	public Properties getProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hiberbate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hiberbate.show_sql", "true");
		
		return properties;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager()
	{
		
		return new HibernateTransactionManager(getSessionFactory());
	
	}

}
