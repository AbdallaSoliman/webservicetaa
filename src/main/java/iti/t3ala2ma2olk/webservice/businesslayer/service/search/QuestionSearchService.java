/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.search;

import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dal.repository.search.AnswersByQuestionIdRepository;
import iti.t3ala2ma2olk.webservice.dal.repository.special.CategoriesRepository;
import iti.t3ala2ma2olk.webservice.dto.special.QuestionCustomDTO;
import iti.t3ala2ma2olk.webservice.test2.service.HibernateSearchService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author abdalla
 */
@Service
public class QuestionSearchService {
       @Autowired
    AnswersByQuestionIdRepository answersByQuestionIdRepository;
       
        @Autowired
    private HibernateSearchService searchservice;
 
    public List<Question> search(String q) {
        List<Question> searchResults = null;
        try {
            searchResults = searchservice.questionSearch(q);

        } catch (Exception ex) {
            // here you should handle unexpected errors
            // ...
            // throw ex;
        }
//        model.addAttribute("search", searchResults);
        return searchResults;

    }
     public List<QuestionCustomDTO> searchCustomization(String q,Pageable pageable) {
      
        
        
        
        List<Question> searchResults = null;
        List<QuestionCustomDTO> searchResultsWithNumbers = new ArrayList();
        try {
            searchResults = searchservice.questionSearch(q);

        } catch (Exception ex) {
            // here you should handle unexpected errors
            // ...
            // throw ex;
        }
        
        searchResults.stream().filter(predicate->predicate.getIsdeleted()!=0).forEach(question ->
                searchResultsWithNumbers.add(new QuestionCustomDTO(
                question.getQuestionId(),
                question.getTitle(),
                (int)question.getAnswersCollection().stream().filter(predicate->predicate.getIsdeleted()==0).count(),
                question.getVerified(),
                 question.getQuestionDate()
                )));
       
        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > searchResultsWithNumbers.size() ? searchResultsWithNumbers.size() : (start + pageable.getPageSize());
        Page<QuestionCustomDTO> pages = new PageImpl<QuestionCustomDTO>(searchResultsWithNumbers.subList(start, end), pageable, searchResultsWithNumbers.size());
    
        
        return pages.getContent();

    }
}
