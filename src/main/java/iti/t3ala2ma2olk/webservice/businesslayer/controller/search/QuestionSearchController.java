/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.search;

import iti.t3ala2ma2olk.webservice.businesslayer.service.search.QuestionSearchService;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dto.special.QuestionCustomDTO;
import iti.t3ala2ma2olk.webservice.test2.service.HibernateSearchService;
import java.util.Comparator;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdalla
 */
@RestController
public class QuestionSearchController {

        @Autowired
    private QuestionSearchService questionSearchService;
    


    @RequestMapping(value = "/QuestionFilter", method = RequestMethod.GET)
    public List<Question> search(@RequestParam(value = "search", required = false) String q) {
        List<Question> searchResults = null;
        
            searchResults = questionSearchService.search(q);


        return searchResults;

    }

    @RequestMapping(value = "/QuestionFilterCustomization", method = RequestMethod.GET)
    public List<QuestionCustomDTO> searchCustomization(@RequestParam(value = "search", required = false) String q,@PageableDefault(value=10, page=0) Pageable pageable) {
      
        
        
        
        List<QuestionCustomDTO> searchResults = null;
       
            searchResults = questionSearchService.searchCustomization(q,pageable);

    
        return searchResults;

    }
}
