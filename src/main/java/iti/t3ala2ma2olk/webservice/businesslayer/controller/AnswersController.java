/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.AnswersService;
import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Answers> getAllAnswers(){
        return answersService.getAllAnswers();
    }
    @RequestMapping("/Answers/{id}")  
    public Answers getAnswers(@PathVariable Integer id){
        return answersService.getAnswers(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/Answers") 
    public void addAnswers(@RequestBody Answers  answers){
        answersService.addAnswers(answers);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/Answers") 
    public void updateAnswers(@RequestBody Answers  answers){
        answersService.updateAnswers(answers);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/Answers/{id}")  
    public void deleteAnswers(@PathVariable Integer id){
         answersService.deleteAnswers(id);
    }
}
