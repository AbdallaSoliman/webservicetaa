/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.TaaUser;
import iti.t3ala2ma2olk.webservice.dal.repository.TaaUserRepository;
import iti.t3ala2ma2olk.webservice.dto.TaaUserDTO;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.AddMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.DeleteMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.FindMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.UpdateMessage;
import iti.t3ala2ma2olk.webservice.dal.entity.TaaUser;
import iti.t3ala2ma2olk.webservice.dal.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class TaaUserService {

    /* using to encode Password to be secur*/
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TaaUserRepository taaUserRepository;
    
    private static final ModelMapper modelMapper = new ModelMapper();

    public List<TaaUser> getAllTaaUser(Pageable pageable) {
        Page page = taaUserRepository.findAll(pageable);
        return page.getContent();
    }

    public ResponseEntity<?> getTaaUser(Integer id) {

        if (modelMapper.map(taaUserRepository.findById(id).orElse(null), TaaUserDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(taaUserRepository.findById(id).orElse(null), TaaUserDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addTaaUser(TaaUser taaUser) {

     
            //   User has been added successfully
            taaUserRepository.save(taaUser);
            return new ResponseEntity<>(AddMessage.success, HttpStatus.OK);
       
    }

    public ResponseEntity<?> updateTaaUser(TaaUser taaUser) {

      
                //   taaUser has been updated successfully 
                 taaUserRepository.save(taaUser);
                  return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
   
    }
    
    public ResponseEntity<?> deleteTaaUser(Integer id) {
        taaUserRepository.deleteById(id);
        return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
    }

}
