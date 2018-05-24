/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.TaaUser;
import iti.t3ala2ma2olk.webservice.dal.repository.TaaUserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class TaaUserService {
        @Autowired
    private TaaUserRepository taaUserRepository;
    
     public List<TaaUser> getAllTaaUser(){
            List<TaaUser> myIntList= new ArrayList<>();
            taaUserRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }
    public  TaaUser getTaaUser(Integer id){
            return taaUserRepository.findById(id).orElse(null);
    }

    public TaaUser addTaaUser(TaaUser taaUser) {
       return taaUserRepository.save(taaUser);
   }
    public TaaUser updateTaaUser(TaaUser taaUser) {
           return  taaUserRepository.save(taaUser);
    }

   public void deleteTaaUser(Integer id) {
         taaUserRepository.deleteById(id);
    }
    
}
