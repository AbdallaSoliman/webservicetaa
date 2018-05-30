/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.profile;

import iti.t3ala2ma2olk.webservice.businesslayer.service.profile.ReportProfileService;
import iti.t3ala2ma2olk.webservice.dto.profile.ReportProfile;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdalla
 */
@RestController
public class ReportProfileContoller {
    
       @Autowired
    private ReportProfileService reportProfileService;
    
        @RequestMapping("/ReportProfile")       
    public List<ReportProfile> getAllAdmin(Pageable pageable){
        return reportProfileService.getAllUserProfile( pageable);
    }
}
