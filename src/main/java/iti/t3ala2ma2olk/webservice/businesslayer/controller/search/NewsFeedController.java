/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.search;

import iti.t3ala2ma2olk.webservice.businesslayer.service.newsfeed.NewsFeedService;
import iti.t3ala2ma2olk.webservice.businesslayer.service.search.QuestionSearchService;
import iti.t3ala2ma2olk.webservice.dto.special.QuestionCustomDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class NewsFeedController {
            @Autowired
    private NewsFeedService newsFeedService;
    
    
        @RequestMapping(value = "/QuestionNewsFeed", method = RequestMethod.GET)
    public List<QuestionCustomDTO> searchCustomization(@PageableDefault(value=10, page=0) Pageable pageable) {
      
        
        
        
        List<QuestionCustomDTO> searchResults = null;
       
            searchResults = newsFeedService.getNewsFeed(pageable);

    
        return searchResults;

    }
}
