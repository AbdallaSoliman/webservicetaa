/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.NotifiAnswersService;
import iti.t3ala2ma2olk.webservice.dal.entity.NotifiAnswers;
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
public class NotifiAnswersController {
     @Autowired
    private NotifiAnswersService notifiAnswersService;
    
        @RequestMapping("/getNotifiAnswers")       
    public List<NotifiAnswers> getAllNotifiAnswers(){
        return notifiAnswersService.getAllNotifiAnswers();
    }
    @RequestMapping("/getNotifiAnswers/{id}")  
    public NotifiAnswers getNotifiAnswers(@PathVariable Integer id){
        return notifiAnswersService.getNotifiAnswers(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/getNotifiAnswers") 
    public void addNotifiAnswers(@RequestBody NotifiAnswers  notifiAnswers){
        notifiAnswersService.addNotifiAnswers(notifiAnswers);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/getNotifiAnswers") 
    public void updateNotifiAnswers(@RequestBody NotifiAnswers  notifiAnswers){
        notifiAnswersService.updateNotifiAnswers(notifiAnswers);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/getNotifiAnswers/{id}")  
    public void deleteNotifiAnswers(@PathVariable Integer id){
         notifiAnswersService.deleteNotifiAnswers(id);
    }
}
