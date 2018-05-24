/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.MainCategories;
import iti.t3ala2ma2olk.webservice.dal.repository.MainCategoriesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class MainCategoriesService {
        @Autowired
    private MainCategoriesRepository mainCategoriesRepository;
    
     public List<MainCategories> getAllMainCategories(){
            List<MainCategories> myIntList= new ArrayList<>();
            mainCategoriesRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }
    public  MainCategories getMainCategories(Integer id){
            return mainCategoriesRepository.findById(id).orElse(null);
    }

    public void addMainCategories(MainCategories topic) {
        mainCategoriesRepository.save(topic);
   }

    public void updateMainCategories(MainCategories topic) {
             mainCategoriesRepository.save(topic);
    }

   public void deleteMainCategories(Integer id) {
         mainCategoriesRepository.deleteById(id);
    }
    
}
