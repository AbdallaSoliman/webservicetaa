/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.AdminService;
import iti.t3ala2ma2olk.webservice.dal.entity.Admin;
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
public class AdminController {
     @Autowired
    private AdminService adminService;
    
        @RequestMapping("/getAdmin")       
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }
    @RequestMapping("/getAdmin/{id}")  
    public Admin getAdmin(@PathVariable Integer id){
        return adminService.getAdmin(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/getAdmin") 
    public void addAdmin(@RequestBody Admin  admin){
        adminService.addAdmin(admin);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/getAdmin") 
    public void updateAdmin(@RequestBody Admin  admin){
        adminService.updateAdmin(admin);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/getAdmin/{id}")  
    public void deleteAdmin(@PathVariable Integer id){
         adminService.deleteAdmin(id);
    }
}
