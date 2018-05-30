/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.TaaUserService;
import iti.t3ala2ma2olk.webservice.dal.entity.TaaUser;
import iti.t3ala2ma2olk.webservice.dal.entity.TaaUser;
import iti.t3ala2ma2olk.webservice.dto.TaaUserDTO;
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
public class TaaUserController {

    @Autowired
    private TaaUserService taaUserService;

    @RequestMapping("/TaaUser")
    public List<TaaUser> getAllTaaUser(@PageableDefault(value=10, page=0) Pageable pageable) {
        return taaUserService.getAllTaaUser(pageable);
    }

    @RequestMapping("/TaaUser/{id}")
    public ResponseEntity<?> getTaaUser(@PathVariable Integer id) {
        return taaUserService.getTaaUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/TaaUser")
    public ResponseEntity<?> addTaaUser(@DTO(TaaUserDTO.class) TaaUser taaUser) {
        return taaUserService.addTaaUser(taaUser);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/TaaUser")
    public ResponseEntity<?> updateTaaUser(@DTO(TaaUserDTO.class) TaaUser taaUser) {
        return taaUserService.updateTaaUser(taaUser);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/TaaUser/{id}")
    public ResponseEntity<?> deleteTaaUser(@PathVariable Integer id) {
        return taaUserService.deleteTaaUser(id);
    }

}
