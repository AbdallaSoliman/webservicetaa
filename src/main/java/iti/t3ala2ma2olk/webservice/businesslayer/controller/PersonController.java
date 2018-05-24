/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.msg.RegistrationMassage;
import iti.t3ala2ma2olk.webservice.businesslayer.service.PersonService;
import iti.t3ala2ma2olk.webservice.security.model.Person;
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
public class PersonController {
     @Autowired
    private PersonService personService;
    
        @RequestMapping("/getPerson")       
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
    @RequestMapping("/getPerson/{id}")  
    public Person getPerson(@PathVariable Integer id){
        return personService.getPerson(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/getPerson") 
    public Person addPerson(@RequestBody Person  person){
      return personService.addPerson(person);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/getPerson") 
    public Person updatePerson(@RequestBody Person  person){
      return  personService.updatePerson(person);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/getPerson/{id}")  
    public void deletePerson(@PathVariable Integer id){
         personService.deletePerson(id);
    }
}
