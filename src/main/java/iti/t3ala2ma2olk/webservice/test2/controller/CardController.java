package iti.t3ala2ma2olk.webservice.test2.controller;


import iti.t3ala2ma2olk.webservice.test2.model.BaseballCard;
import iti.t3ala2ma2olk.webservice.test2.service.CardService;
import iti.t3ala2ma2olk.webservice.test2.service.HibernateSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CardController {

    @Autowired
    private HibernateSearchService searchservice;

    @Autowired
    private CardService cardservice;

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String search(@RequestParam(value = "search", required = false) String q, Model model) {
        List<BaseballCard> searchResults = null;
        try {
            cardservice.addCards();
            searchResults = searchservice.fuzzySearch(q);

        } catch (Exception ex) {
            // here you should handle unexpected errors
            // ...
            // throw ex;
        }
        model.addAttribute("search", searchResults);
        return searchResults.get(0).getName();

    }

}
