/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.SubCat;
import iti.t3ala2ma2olk.webservice.dal.repository.SubCatRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class SubCatService {
        @Autowired
    private SubCatRepository subCatRepository;
    
     public List<SubCat> getAllSubCat(){
            List<SubCat> myIntList= new ArrayList<>();
            subCatRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }
    public  SubCat getSubCat(Integer id){
            return subCatRepository.findById(id).orElse(null);
    }

    public void addSubCat(SubCat topic) {
        subCatRepository.save(topic);
   }

    public void updateSubCat(SubCat topic) {
             subCatRepository.save(topic);
    }

   public void deleteSubCat(Integer id) {
         subCatRepository.deleteById(id);
    }
    
}
