/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.profile;

import iti.t3ala2ma2olk.webservice.businesslayer.service.profile.CustomerServiceProfileService;
import iti.t3ala2ma2olk.webservice.dto.profile.CustomerServiceProfile;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author abdalla
 */
public class CustomerServiceController {
             @Autowired
    private CustomerServiceProfileService customerServiceProfileService;
    
        @RequestMapping("/CustomerServiceProfile")       
    public List<CustomerServiceProfile> getAllAdmin(@PageableDefault(value=1000, page=0) Pageable pageable){
        return customerServiceProfileService.getAllUserProfile(pageable);
    }  
}
