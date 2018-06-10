package iti.t3ala2ma2olk.webservice.config;


import iti.t3ala2ma2olk.webservice.test2.service.HibernateSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

//@EnableAutoConfiguration
@Configuration
public class HibernateSearchConfiguration {

    private final Logger logger = LoggerFactory.getLogger(HibernateSearchConfiguration.class);
    
    @Autowired
    private EntityManager bentityManager;

    @Bean
    HibernateSearchService hibernateSearchService() {
        HibernateSearchService hibernateSearchService = new HibernateSearchService(bentityManager);
        hibernateSearchService.initializeHibernateSearch();
        return hibernateSearchService;
    }
}