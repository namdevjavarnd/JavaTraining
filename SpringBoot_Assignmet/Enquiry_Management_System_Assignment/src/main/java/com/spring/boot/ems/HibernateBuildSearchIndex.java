

package com.spring.boot.ems;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.spring.boot.ems.service.EnquiryService;

@Transactional
@Component
public class HibernateBuildSearchIndex implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger logger = LoggerFactory.getLogger(HibernateBuildSearchIndex.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        try {
            FullTextEntityManager fullTextEntityManager
                    = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager
                    .createIndexer()
                    .startAndWait();
        } catch (InterruptedException e) {
            logger.error("An error occurred when trying to build the search index: "
                    + e.toString());
        }
        return;
    }

}


















