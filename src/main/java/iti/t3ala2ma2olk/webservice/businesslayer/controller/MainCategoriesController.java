/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.MainCategoriesService;
import iti.t3ala2ma2olk.webservice.dal.entity.MainCategories;
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
public class MainCategoriesController {
     @Autowired
    private MainCategoriesService mainCategoriesService;
    
        @RequestMapping("/MainCategories")       
    public List<MainCategories> getAllMainCategories(){
        return mainCategoriesService.getAllMainCategories();
    }
    @RequestMapping("/MainCategories/{id}")  
    public MainCategories getMainCategories(@PathVariable Integer id){
        return mainCategoriesService.getMainCategories(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/MainCategories") 
    public void addMainCategories(@RequestBody MainCategories  mainCategories){
        mainCategoriesService.addMainCategories(mainCategories);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/MainCategories") 
    public void updateMainCategories(@RequestBody MainCategories  mainCategories){
        mainCategoriesService.updateMainCategories(mainCategories);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/MainCategories/{id}")  
    public void deleteMainCategories(@PathVariable Integer id){
         mainCategoriesService.deleteMainCategories(id);
    }
}
