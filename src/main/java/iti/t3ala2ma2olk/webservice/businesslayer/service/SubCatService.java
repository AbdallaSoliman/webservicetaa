/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.SubCat;
import iti.t3ala2ma2olk.webservice.dal.repository.SubCatRepository;
import iti.t3ala2ma2olk.webservice.dto.SubCatDTO;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.AddMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.DeleteMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.FindMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.LoginMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.RegistrationMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.UpdateMessage;
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
public class SubCatService {

    @Autowired
    private SubCatRepository subCatRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    public List<SubCat> getAllSubCat(Pageable pageable) {
        Page page = subCatRepository.findAll(pageable);
        return page.getContent();
    }

    public ResponseEntity<?> getSubCat(Integer id) {

        if (modelMapper.map(subCatRepository.findById(id).orElse(null), SubCatDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(subCatRepository.findById(id).orElse(null), SubCatDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addSubCat(SubCat subCat) {


            subCat.setSubCatId(null);
            //   SubCat  has been added successfully
            subCatRepository.save(subCat);
            return new ResponseEntity<>(AddMessage.success, HttpStatus.OK);
        
    }

    public ResponseEntity<?> updateSubCat(SubCat subCat) {
        SubCat userExists = subCatRepository.findById(subCat.getSubCatId()).orElse(null);
        if (userExists != null) {

                 subCatRepository.save(subCat);
                  return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
   
        } else {
            // There is a updateSubCat  registered with this id
            return new ResponseEntity<>(UpdateMessage.idNotFound, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteSubCat(Integer id) {
        subCatRepository.deleteById(id);
        return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
    }


}
