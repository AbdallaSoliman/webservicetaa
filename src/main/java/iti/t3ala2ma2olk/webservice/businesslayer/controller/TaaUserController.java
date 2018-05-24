/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.TaaUserService;
import iti.t3ala2ma2olk.webservice.dal.entity.TaaUser;
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
public class TaaUserController {
     @Autowired
    private TaaUserService taaUserService;
    
        @RequestMapping("/TaaUser")       
    public List<TaaUser> getAllTaaUser(){
        return taaUserService.getAllTaaUser();
    }
    @RequestMapping("/TaaUser/{id}")  
    public TaaUser getTaaUser(@PathVariable Integer id){
        return taaUserService.getTaaUser(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/TaaUser") 
    public TaaUser addTaaUser(@RequestBody TaaUser  taaUser){
       return taaUserService.addTaaUser(taaUser);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/TaaUser") 
    public TaaUser updateTaaUser(@RequestBody TaaUser  taaUser){
      return  taaUserService.updateTaaUser(taaUser);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/TaaUser/{id}")  
    public void deleteTaaUser(@PathVariable Integer id){
         taaUserService.deleteTaaUser(id);
    }
}
