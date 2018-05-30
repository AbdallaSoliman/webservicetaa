/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.CustomerServiceService;
import iti.t3ala2ma2olk.webservice.dal.entity.CustomerService;
import iti.t3ala2ma2olk.webservice.dal.entity.CustomerService;
import iti.t3ala2ma2olk.webservice.dto.CustomerServiceDTO;
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
public class CustomerServiceController {

    @Autowired
    private CustomerServiceService customerServiceService;

    @RequestMapping("/CustomerService")
    public List<CustomerService> getAllCustomerService(@PageableDefault(value=10, page=0) Pageable pageable) {
        return customerServiceService.getAllCustomerService(pageable);
    }

    @RequestMapping("/CustomerService/{id}")
    public ResponseEntity<?> getCustomerService(@PathVariable Integer id) {
        return customerServiceService.getCustomerService(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/CustomerService")
    public ResponseEntity<?> addCustomerService(@DTO(CustomerServiceDTO.class) CustomerService customerService) {
        return customerServiceService.addCustomerService(customerService);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/CustomerService")
    public ResponseEntity<?> updateCustomerService(@DTO(CustomerServiceDTO.class) CustomerService customerService) {
        return customerServiceService.updateCustomerService(customerService);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/CustomerService/{id}")
    public ResponseEntity<?> deleteCustomerService(@PathVariable Integer id) {
        return customerServiceService.deleteCustomerService(id);
    }

}
