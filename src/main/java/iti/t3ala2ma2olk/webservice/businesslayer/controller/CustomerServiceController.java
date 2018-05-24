/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.CustomerServiceService;
import iti.t3ala2ma2olk.webservice.dal.entity.CustomerService;
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
public class CustomerServiceController {
     @Autowired
    private CustomerServiceService customerServiceService;
    
        @RequestMapping("/CustomerService")       
    public List<CustomerService> getAllCustomerService(){
        return customerServiceService.getAllCustomerService();
    }
    @RequestMapping("/CustomerService/{id}")  
    public CustomerService getCustomerService(@PathVariable Integer id){
        return customerServiceService.getCustomerService(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/CustomerService") 
    public CustomerService addCustomerService(@RequestBody CustomerService  customerService){
       return customerServiceService.addCustomerService(customerService);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/CustomerService") 
    public CustomerService updateCustomerService(@RequestBody CustomerService  customerService){
      return  customerServiceService.updateCustomerService(customerService);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/CustomerService/{id}")  
    public void deleteCustomerService(@PathVariable Integer id){
         customerServiceService.deleteCustomerService(id);
    }
}
