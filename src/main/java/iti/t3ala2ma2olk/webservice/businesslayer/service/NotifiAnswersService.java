/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.NotifiAnswers;
import iti.t3ala2ma2olk.webservice.dal.repository.NotifiAnswersRepository;
import iti.t3ala2ma2olk.webservice.dto.NotifiAnswersDTO;
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
public class NotifiAnswersService {

    @Autowired
    private NotifiAnswersRepository notifiAnswersRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    public List<NotifiAnswers> getAllNotifiAnswers(Pageable pageable) {
        Page page = notifiAnswersRepository.findAll(pageable);
        return page.getContent();
    }

    public ResponseEntity<?> getNotifiAnswers(Integer id) {

        if (modelMapper.map(notifiAnswersRepository.findById(id).orElse(null), NotifiAnswersDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(notifiAnswersRepository.findById(id).orElse(null), NotifiAnswersDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addNotifiAnswers(NotifiAnswers notifiAnswers) {


            notifiAnswers.setNotifiId(null);
            //   categorie  has been added successfully
            notifiAnswersRepository.save(notifiAnswers);
            return new ResponseEntity<>(AddMessage.success, HttpStatus.OK);
        
    }

    public ResponseEntity<?> updateNotifiAnswers(NotifiAnswers notifiAnswers) {
        NotifiAnswers userExists = notifiAnswersRepository.findById(notifiAnswers.getNotifiId()).orElse(null);
        if (userExists != null) {

                 notifiAnswersRepository.save(notifiAnswers);
                  return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
   
        } else {
            // There is a updateNotifiAnswers  registered with this id
            return new ResponseEntity<>(UpdateMessage.idNotFound, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteNotifiAnswers(Integer id) {
        notifiAnswersRepository.deleteById(id);
        return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
    }


}
