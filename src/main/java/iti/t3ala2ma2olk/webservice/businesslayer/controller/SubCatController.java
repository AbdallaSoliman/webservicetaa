/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.SubCatService;
import iti.t3ala2ma2olk.webservice.dal.entity.SubCat;
import iti.t3ala2ma2olk.webservice.dal.entity.SubCat;
import iti.t3ala2ma2olk.webservice.dto.SubCatDTO;
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
public class SubCatController {

    @Autowired
    private SubCatService subCatService;

    @RequestMapping("/SubCat")
    public List<SubCat> getAllSubCat(@PageableDefault(value=10, page=0) Pageable pageable) {
        return subCatService.getAllSubCat(pageable);
    }

    @RequestMapping("/SubCat/{id}")
    public ResponseEntity<?> getSubCat(@PathVariable Integer id) {
        return subCatService.getSubCat(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/SubCat")
    public ResponseEntity<?> addSubCat(@DTO(SubCatDTO.class) SubCat subCat) {
        return subCatService.addSubCat(subCat);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/SubCat")
    public ResponseEntity<?> updateSubCat(@DTO(SubCatDTO.class) SubCat subCat) {
        return subCatService.updateSubCat(subCat);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/SubCat/{id}")
    public ResponseEntity<?> deleteSubCat(@PathVariable Integer id) {
        return subCatService.deleteSubCat(id);
    }

}
