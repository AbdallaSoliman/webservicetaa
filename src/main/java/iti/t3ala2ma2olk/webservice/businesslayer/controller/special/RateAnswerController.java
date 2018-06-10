/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.special;

import io.jsonwebtoken.ExpiredJwtException;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.AddMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.RateMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.service.QuestionService;
import iti.t3ala2ma2olk.webservice.businesslayer.service.special.RateAnswerService;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dal.repository.PersonRepository;
import iti.t3ala2ma2olk.webservice.dal.repository.QuestionRepository;
import iti.t3ala2ma2olk.webservice.security.JwtTokenUtil;
import iti.t3ala2ma2olk.webservice.security.TokenHandler;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
public class RateAnswerController {

    @Autowired
    private RateAnswerService rateAnswerService;

    @RequestMapping("/AnswerRateUp/{id}")
    public ResponseEntity<?> answersRateUp(HttpServletRequest request, @PathVariable Integer id) {
        System.out.println("answersRateUp id "+id);
        return rateAnswerService.answersRateUp(request, id);
    }

    @RequestMapping("/AnswerRateDown/{id}")
    public ResponseEntity<?> answersRateDown(HttpServletRequest request, @PathVariable Integer id) {
        return rateAnswerService.answersRateDown(request, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/AnswerRateUp/{id}")
    public ResponseEntity<?> answersRateUpRemove(HttpServletRequest request, @PathVariable Integer id) {
        return rateAnswerService.answersRateUpRemove(request, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/AnswerRatedDown/{id}")
    public ResponseEntity<?> answersRateRemove(HttpServletRequest request, @PathVariable Integer id) {
        return rateAnswerService.answersRateDownRemove(request, id);
    }

}
