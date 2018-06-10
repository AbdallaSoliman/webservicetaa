/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.MainCategories;
import iti.t3ala2ma2olk.webservice.dal.repository.MainCategoriesRepository;
import iti.t3ala2ma2olk.webservice.dto.MainCategoriesDTO;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.AddMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.DeleteMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.FindMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.LoginMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.RegistrationMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.UpdateMessage;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import iti.t3ala2ma2olk.webservice.businesslayer.factory.ModelMapperFactory;
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
public class MainCategoriesService {

    @Autowired
    private MainCategoriesRepository mainCategoriesRepository;

       private static final ModelMapper modelMapper = ModelMapperFactory.getModelMapper();

    public List<MainCategories> getAllMainCategories(Pageable pageable) {
        Page page = mainCategoriesRepository.findAll(pageable);
        return page.getContent();
    }

    public ResponseEntity<?> getMainCategories(Integer id) {

        if (modelMapper.map(mainCategoriesRepository.findById(id).orElse(null), MainCategoriesDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(mainCategoriesRepository.findById(id).orElse(null), MainCategoriesDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addMainCategories(MainCategories mainCategories) {

        if (mainCategoriesRepository.findByCatName(mainCategories.getCatName()) != null) {
            //     There is already a Categories added with this  name
            return new ResponseEntity<>(AddMessage.fail, HttpStatus.OK);
        } else {
            mainCategories.setMainCategoriesId(null);
            //   categorie  has been added successfully
            mainCategoriesRepository.save(mainCategories);
            return new ResponseEntity<>(AddMessage.success, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> updateMainCategories(MainCategories mainCategories) {
        MainCategories userExists = mainCategoriesRepository.findById(mainCategories.getMainCategoriesId()).orElse(null);
        if (userExists != null) {
            if (((mainCategoriesRepository.findByCatName(mainCategories.getCatName()) == null))
                    || ((userExists.getCatName().equals(mainCategories.getCatName())))) {
                //   Categorie has been updated successfully 
                 mainCategoriesRepository.save(mainCategories);
                  return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
            }else{
                  return new ResponseEntity<>(UpdateMessage.uniqueField, HttpStatus.OK); 
            }
        } else {
            // There is a categorie  registered with this id
            return new ResponseEntity<>(UpdateMessage.idNotFound, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteMainCategories(Integer id) {
        mainCategoriesRepository.deleteById(id);
        return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
    }


}
