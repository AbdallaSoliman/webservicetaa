/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.QuestionService;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dto.QuestionDTO;
import iti.t3ala2ma2olk.webservice.dto.profile.LoginProfile;
import iti.t3ala2ma2olk.webservice.dto.profile.util.DTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/Question")
    public List<Question> getAllQuestion(@PageableDefault(value=10, page=0) Pageable pageable) {
        return questionService.getAllQuestion(pageable);
    }

    @RequestMapping("/Question/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable Integer id) {
        return questionService.getQuestion(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Question")
    public ResponseEntity<?> addQuestion(@DTO(QuestionDTO.class) Question question) {
        return questionService.addQuestion(question);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Question")
    public ResponseEntity<?> updateQuestion(@DTO(QuestionDTO.class) Question question) {
        return questionService.updateQuestion(question);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Question/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

}
