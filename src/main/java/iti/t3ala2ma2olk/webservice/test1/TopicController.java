/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.test1;


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
public class TopicController {
    
    @Autowired
    private TopicService topicService;
    
        @RequestMapping("/Topics")       
    public List<Question> getAllTopic(){
        return topicService.getAllTopic();
    }
    @RequestMapping("/Topics/{id}")  
    public Question getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/Topics") 
    public void addTopic(@RequestBody Question  topic){
        topicService.addTopic(topic);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/Topics/{id}") 
    public void updateTopic(@RequestBody Question  topic,@PathVariable String id){
        topicService.updateTopic(id,topic);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/Topics/{id}")  
    public void deleteTopic(@PathVariable String id){
         topicService.deleteTopic(id);
    }
}