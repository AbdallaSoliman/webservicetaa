/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.AnswersService;
import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.dto.AnswersDTO;
import iti.t3ala2ma2olk.webservice.dto.profile.LoginProfile;
import iti.t3ala2ma2olk.webservice.dto.profile.util.DTO;
import java.util.List;
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
public class AnswersController {

    @Autowired
    private AnswersService answersService;

    @RequestMapping("/Answers")
    public List<Answers> getAllAnswers() {
        return answersService.getAllAnswers();
    }

    @RequestMapping("/Answers/{id}")
    public ResponseEntity<?> getAnswers(@PathVariable Integer id) {
        return answersService.getAnswers(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Answers")
    public ResponseEntity<?> addAnswers(@DTO(AnswersDTO.class) Answers answers) {
        return answersService.addAnswers(answers);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Answers")
    public ResponseEntity<?> updateAnswers(@DTO(AnswersDTO.class) Answers answers) {
        return answersService.updateAnswers(answers);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Answers/{id}")
    public ResponseEntity<?> deleteAnswers(@PathVariable Integer id) {
        return answersService.deleteAnswers(id);
    }

}
