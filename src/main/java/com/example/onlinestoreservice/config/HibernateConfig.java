package com.example.onlinestoreservice.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.example.onlinestoreservice")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfig {

   /* @Bean
    public EntityManagerFactory getEntityMangerFactory(){
        return Persistence.createEntityManagerFactory("OnlineStorePersistence");
    }

    @Bean(name = "entityManager")
    public EntityManager getEntityManager(EntityManagerFactory factory){

        System.out.println("i've been initialized");
EntityManager e =  factory.createEntityManager();
        System.out.println(e.toString());
        return e;
    }*/

   @Value(value = "${spring.datasource.url}")
   private  String DATABASE_URL ;
    @Value(value = "${spring.datasource.driver-class-name}")
    private  String DATABASE_DRIVER ;
    @Value(value = "${spring.jpa.properties.hibernate.dialect}")
    private  String DATABASE_DIALECT ;
    @Value(value = "${spring.datasource.username}")
    private  String DATABASE_USERNAME ;
    @Value(value = "${spring.datasource.password}")
    private String DATABASE_PASSWORD ;

    @Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
        return dataSource;
    }

    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource){
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.addProperties(getHibernateProperties());
        builder.scanPackages("com.example.onlinestoreservice.dto");
        return builder.buildSessionFactory();
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
         HibernateTransactionManager manager = new HibernateTransactionManager(sessionFactory);
    return manager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", DATABASE_DIALECT);
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.format_sql","true");
        return properties;
    }

}
