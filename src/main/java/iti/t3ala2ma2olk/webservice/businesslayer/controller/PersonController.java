/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.PersonService;

import iti.t3ala2ma2olk.webservice.dto.PersonDTO;
import iti.t3ala2ma2olk.webservice.dto.profile.LoginProfile;
import iti.t3ala2ma2olk.webservice.dto.profile.util.DTO;
import iti.t3ala2ma2olk.webservice.security.model.Person;
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
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/Person")
    public List<Person> getAllPerson(@PageableDefault(value=10, page=0) Pageable pageabl) {
        return personService.getAllPerson(pageabl);
    }

    @RequestMapping("/Person/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Integer id) {
        return personService.getPerson(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Person")
    public ResponseEntity<?> addPerson(@DTO(PersonDTO.class) Person person) {
        return personService.addPerson(person);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Person")
    public ResponseEntity<?> updatePerson(@DTO(PersonDTO.class) Person person) {
        return personService.updatePerson(person);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Person/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Integer id) {
        return personService.deletePerson(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Person/Login")
    public ResponseEntity<?> login(@DTO(LoginProfile.class) Person person) {
        return personService.login(person);
    }
}
