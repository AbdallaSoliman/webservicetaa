/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.SubCatService;
import iti.t3ala2ma2olk.webservice.dal.entity.SubCat;
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
public class SubCatController {
     @Autowired
    private SubCatService subCatService;
    
        @RequestMapping("/getSubCat")       
    public List<SubCat> getAllSubCat(){
        return subCatService.getAllSubCat();
    }
    @RequestMapping("/getSubCat/{id}")  
    public SubCat getSubCat(@PathVariable Integer id){
        return subCatService.getSubCat(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/getSubCat") 
    public void addSubCat(@RequestBody SubCat  subCat){
        subCatService.addSubCat(subCat);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/getSubCat") 
    public void updateSubCat(@RequestBody SubCat  subCat){
        subCatService.updateSubCat(subCat);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/getSubCat/{id}")  
    public void deleteSubCat(@PathVariable Integer id){
         subCatService.deleteSubCat(id);
    }
}
