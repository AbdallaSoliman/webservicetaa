/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.dal.repository.AnswersRepository;
import iti.t3ala2ma2olk.webservice.dto.AnswersDTO;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class AnswersService {

    /* using to encode Password to be secur*/
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AnswersRepository answersRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    public List<Answers> getAllAnswers() {
        List<Answers> myIntList = new ArrayList<>();
        answersRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }

    public ResponseEntity<?> getAnswers(Integer id) {

        if (modelMapper.map(answersRepository.findById(id).orElse(null), AnswersDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(answersRepository.findById(id).orElse(null), AnswersDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addAnswers(Answers answers) {

//        if (answersRepository.findByQuestionId(answers.getQuestionId()) != null) {
//            //     There is already a user registered with this user name
//            return new ResponseEntity<>(AddMessage.fail, HttpStatus.OK);
//        } else {
            answers.setAnswersId(null);
            //   User has been registered successfully
            answersRepository.save(answers);
            return new ResponseEntity<>(AddMessage.success, HttpStatus.OK);
//        }
    }

    public ResponseEntity<?> updateAnswers(Answers answers) {
//        Answers userExists = answersRepository.findById(answers.getAnswersId()).orElse(null);
//        if (userExists != null) {
//            if (((answersRepository.findByUsername(answers.getUsername()) == null))
//                    || ((userExists.getUsername().equals(answers.getUsername())))) {
//                if (!userExists.getPassword().equals(answers.getPassword())) {
//                    answers.setPassword(bCryptPasswordEncoder.encode(answers.getPassword()));
//                }
//                //   answers has been updated successfully 
//                 answersRepository.save(answers);
//                  return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
//        } else {
//            // There is a user registered with this id
//            return new ResponseEntity<>(UpdateMessage.idNotFound, HttpStatus.OK);
//        }
//    }
          return new ResponseEntity<>(UpdateMessage.fail, HttpStatus.OK);
    }
    public ResponseEntity<?> deleteAnswers(Integer id) {
        answersRepository.deleteById(id);
        return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
    }

}
