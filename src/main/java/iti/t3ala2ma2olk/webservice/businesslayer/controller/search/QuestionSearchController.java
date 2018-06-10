/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.search;

import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.test2.service.HibernateSearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    private HibernateSearchService searchservice;


    @RequestMapping(value = "/QuestionFilter", method = RequestMethod.GET)
    public List<Question> search(@RequestParam(value = "search", required = false) String q) {
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
}
