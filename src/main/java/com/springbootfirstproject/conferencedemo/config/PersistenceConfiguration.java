package com.springbootfirstproject.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    //this bean overrides all configuraiton set in application properties files, comment it if you don't want it
   /* @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/conference").username("root").password("123321");
       // System.out.println("DataSource bean has been created and set to 1233211 and that's a wrong password");
        return dataSourceBuilder.build();
    }*/
}
