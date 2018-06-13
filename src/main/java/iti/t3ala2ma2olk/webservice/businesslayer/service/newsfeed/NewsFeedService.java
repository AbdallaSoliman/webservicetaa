/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.newsfeed;

import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dal.repository.QuestionRepository;
import iti.t3ala2ma2olk.webservice.dal.repository.search.AnswersByQuestionIdRepository;
import iti.t3ala2ma2olk.webservice.dto.special.QuestionCustomDTO;
import iti.t3ala2ma2olk.webservice.test2.service.HibernateSearchService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class NewsFeedService {
    
           @Autowired
    AnswersByQuestionIdRepository answersByQuestionIdRepository;
       
        
        @Autowired
    private QuestionRepository questionRepository;
        public List<QuestionCustomDTO> getNewsFeed(Pageable pageable) {
      
        
        
        
        Page<Question> pages = null;
        List<QuestionCustomDTO> searchResultsWithNumbers = new ArrayList();
    
            pages = questionRepository.findAll(pageable);


        
        pages.getContent().stream().forEach(question -> 
                searchResultsWithNumbers.add(new QuestionCustomDTO(
                question.getQuestionId(),
                question.getTitle(),
                answersByQuestionIdRepository.findByQuestionId(question).size(),
                question.getVerified(),
                 question.getQuestionDate()
                )));
       

        
        return searchResultsWithNumbers;

    } 
}
