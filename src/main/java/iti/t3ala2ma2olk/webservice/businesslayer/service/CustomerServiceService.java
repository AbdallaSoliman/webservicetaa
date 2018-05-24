/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.CustomerService;
import iti.t3ala2ma2olk.webservice.dal.repository.CustomerServiceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class CustomerServiceService {
        @Autowired
    private CustomerServiceRepository customerServiceRepository;
    
     public List<CustomerService> getAllCustomerService(){
            List<CustomerService> myIntList= new ArrayList<>();
            customerServiceRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }
    public  CustomerService getCustomerService(Integer id){
            return customerServiceRepository.findById(id).orElse(null);
    }

    public CustomerService addCustomerService(CustomerService topic) {
       return customerServiceRepository.save(topic);
   }

    public CustomerService updateCustomerService(CustomerService topic) {
           return  customerServiceRepository.save(topic);
    }

   public void deleteCustomerService(Integer id) {
         customerServiceRepository.deleteById(id);
    }
    
}
