/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.CustomerService;
import iti.t3ala2ma2olk.webservice.dal.repository.CustomerServiceRepository;
import iti.t3ala2ma2olk.webservice.dto.CustomerServiceDTO;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.AddMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.DeleteMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.FindMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.UpdateMessage;
import iti.t3ala2ma2olk.webservice.dal.entity.CustomerService;
import iti.t3ala2ma2olk.webservice.dal.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class CustomerServiceService {

    /* using to encode Password to be secur*/

    
    
    @Autowired
    private CustomerServiceRepository customerServiceRepository;
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public List<CustomerService> getAllCustomerService(Pageable pageable) {
        Page page = customerServiceRepository.findAll(pageable);
        return page.getContent();
    }

    public ResponseEntity<?> getCustomerService(Integer id) {

        if (modelMapper.map(customerServiceRepository.findById(id).orElse(null), CustomerServiceDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(customerServiceRepository.findById(id).orElse(null), CustomerServiceDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addCustomerService(CustomerService customerService) {

     
            //   User has been added successfully
            customerServiceRepository.save(customerService);
            return new ResponseEntity<>(AddMessage.success, HttpStatus.OK);
       
    }

    public ResponseEntity<?> updateCustomerService(CustomerService customerService) {

      
                //   customerService has been updated successfully 
                 customerServiceRepository.save(customerService);
                  return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
   
    }
    
    public ResponseEntity<?> deleteCustomerService(Integer id) {
        customerServiceRepository.deleteById(id);
        return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
    }

}
