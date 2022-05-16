package by.iba.onlineshop.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/online_shop");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory(@Autowired DataSource dataSource) throws IOException {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		Properties properties = new Properties();
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		properties.put(Environment.SHOW_SQL, "true");
		properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,
				"org.springframework.orm.hibernate5.SpringSessionContext");

		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("by.iba.onlineshop.entities");
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();

		return factoryBean.getObject();
	}

	@Bean
	public HibernateTransactionManager transactionManager(@Autowired SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}
