/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.QuestionService;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
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
public class QuestionController {
     @Autowired
    private QuestionService questionService;
    
        @RequestMapping("/getQuestion")       
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestion();
    }
    @RequestMapping("/getQuestion/{id}")  
    public Question getQuestion(@PathVariable Integer id){
        return questionService.getQuestion(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/getQuestion") 
    public void addQuestion(@RequestBody Question  question){
        questionService.addQuestion(question);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/getQuestion") 
    public void updateQuestion(@RequestBody Question  question){
        questionService.updateQuestion(question);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/getQuestion/{id}")  
    public void deleteQuestion(@PathVariable Integer id){
         questionService.deleteQuestion(id);
    }
}
