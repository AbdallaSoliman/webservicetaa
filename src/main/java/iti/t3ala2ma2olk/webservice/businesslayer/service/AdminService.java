/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;


import iti.t3ala2ma2olk.webservice.dal.entity.Admin;
import iti.t3ala2ma2olk.webservice.dal.repository.AdminRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
     public List<Admin> getAllAdmin(){
            List<Admin> myIntList= new ArrayList<>();
            adminRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }
    public  Admin getAdmin(Integer id){
            return adminRepository.findById(id).orElse(null);
    }

    public void addAdmin(Admin topic) {
        adminRepository.save(topic);
   }

    public void updateAdmin(Admin topic) {
             adminRepository.save(topic);
    }

   public void deleteAdmin(Integer id) {
         adminRepository.deleteById(id);
    }
    
}
