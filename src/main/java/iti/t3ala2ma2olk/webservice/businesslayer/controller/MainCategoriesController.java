/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.MainCategoriesService;
import iti.t3ala2ma2olk.webservice.dal.entity.MainCategories;
import iti.t3ala2ma2olk.webservice.dto.MainCategoriesDTO;
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
public class MainCategoriesController {

    @Autowired
    private MainCategoriesService mainCategoriesService;

    @RequestMapping("/MainCategories")
    public List<MainCategories> getAllMainCategories(@PageableDefault(value=10, page=0) Pageable pageabl) {
        return mainCategoriesService.getAllMainCategories(pageabl);
    }

    @RequestMapping("/MainCategories/{id}")
    public ResponseEntity<?> getMainCategories(@PathVariable Integer id) {
        return mainCategoriesService.getMainCategories(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/MainCategories")
    public ResponseEntity<?> addMainCategories(@DTO(MainCategoriesDTO.class) MainCategories mainCategories) {
        return mainCategoriesService.addMainCategories(mainCategories);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/MainCategories")
    public ResponseEntity<?> updateMainCategories(@DTO(MainCategoriesDTO.class) MainCategories mainCategories) {
        return mainCategoriesService.updateMainCategories(mainCategories);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/MainCategories/{id}")
    public ResponseEntity<?> deleteMainCategories(@PathVariable Integer id) {
        return mainCategoriesService.deleteMainCategories(id);
    }

}
