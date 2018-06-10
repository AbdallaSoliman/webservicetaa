/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.special;

import iti.t3ala2ma2olk.webservice.businesslayer.service.special.RateQuestionService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdalla
 */
@RestController
public class RateQuestionController {
        @Autowired
    private RateQuestionService rateQuestionService;

    @RequestMapping("/QuestionRateUp/{id}")
    public ResponseEntity<?> questionRateUp(HttpServletRequest request, @PathVariable Integer id) {
        System.out.println("questionRateUp id "+id);
        return rateQuestionService.questionRateUp(request, id);
    }

    @RequestMapping("/QuestionRateDown/{id}")
    public ResponseEntity<?> questionRateDown(HttpServletRequest request, @PathVariable Integer id) {
        return rateQuestionService.questionRateDown(request, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/QuestionRateUp/{id}")
    public ResponseEntity<?> questionRateUpRemove(HttpServletRequest request, @PathVariable Integer id) {
        return rateQuestionService.questionRateUpRemove(request, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/QuestionRatedDown/{id}")
    public ResponseEntity<?> questionRateRemove(HttpServletRequest request, @PathVariable Integer id) {
        return rateQuestionService.questionRateDownRemove(request, id);
    }
}
