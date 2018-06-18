/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.special;

import iti.t3ala2ma2olk.webservice.businesslayer.service.special.PersonSpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alzantot
 */

@RestController
public class PersonSpecialController {
    
    @Autowired
    private PersonSpecialService personSpecialService;
    
    
    @RequestMapping("/PersonSpecial/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Integer id) {
        return personSpecialService.getPerson(id);
    }

    
}
