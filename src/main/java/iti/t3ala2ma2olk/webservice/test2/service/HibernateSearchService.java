package iti.t3ala2ma2olk.webservice.test2.service;


import iti.t3ala2ma2olk.webservice.test2.model.BaseballCard;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

import ch.qos.logback.classic.Logger;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import org.slf4j.LoggerFactory;
@Service
public class HibernateSearchService {

       private final Logger logger = (Logger) LoggerFactory.getLogger(HibernateSearchService.class);

    @Autowired
    private final EntityManager centityManager;


    @Autowired
    public HibernateSearchService(EntityManager entityManager) {
        super();
        entityManager=entityManager.getEntityManagerFactory().createEntityManager();
        this.centityManager = entityManager;
  
//Session session = (Session) entityManager.unwrap(Session.class);
    }


    public void initializeHibernateSearch() {

        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public List<BaseballCard> fuzzySearch(String searchTerm) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(BaseballCard.class).get();
        Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("name","rarityLevel")
                .matching(searchTerm).createQuery();

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, BaseballCard.class);

        // execute search

        List<BaseballCard> BaseballCardList = null;
        try {
            BaseballCardList = jpaQuery.getResultList();
        } catch (NoResultException nre) {
            ;// do nothing

        }

        return BaseballCardList;


    }
        @Transactional
    public List<Question> questionSearch(String searchTerm) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Question.class).get();
        Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("title","body")
                .matching(searchTerm).createQuery();

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Question.class);

        // execute search

        List<Question> QuestionList = null;
        try {
            QuestionList = jpaQuery.getResultList();
        } catch (NoResultException nre) {
            ;// do nothing

        }

        return QuestionList;


    }
}
