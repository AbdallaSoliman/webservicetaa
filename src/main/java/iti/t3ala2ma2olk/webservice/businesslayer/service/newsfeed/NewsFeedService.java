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
         //abdalla start
        List<Question> list = new ArrayList();
        List<QuestionCustomDTO> filteredlist = new ArrayList();

        questionRepository.findAll().forEach(list::add);
                list.stream().filter(predicate->predicate.getIsdeleted()==0).forEach((Question question) -> 
                filteredlist.add(new QuestionCustomDTO(
                question.getQuestionId(),
                question.getTitle(),
                (int)question.getAnswersCollection().stream().filter(predicate->predicate.getIsdeleted()==0).count(),
                question.getVerified(),
                 question.getQuestionDate()
                )));
        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > filteredlist.size() ? filteredlist.size() : (start + pageable.getPageSize());
        Page<QuestionCustomDTO> pages = new PageImpl<QuestionCustomDTO>(filteredlist.subList(start, end), pageable, filteredlist.size());

        return pages.getContent();
        //abdalla end     
        
        
      

    } 
}
