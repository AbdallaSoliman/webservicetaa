/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.unittest;

import iti.t3ala2ma2olk.webservice.businesslayer.service.CustomerServiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author abdalla
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceUT {
       @Autowired
    private CustomerServiceService customerServiceService;
   
     private final Logger logger = LoggerFactory.getLogger(this.getClass());
   
    @Test
    public void invokeAOPStuff() {
       logger.info(customerServiceService.toString());
        
  
    }
}
