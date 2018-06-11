/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dal.repository.QuestionRepository;
import iti.t3ala2ma2olk.webservice.dto.QuestionDTO;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.AddMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.DeleteMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.FindMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.LoginMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.RegistrationMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.UpdateMessage;
import iti.t3ala2ma2olk.webservice.pushnotification.NotificationFactory;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import iti.t3ala2ma2olk.webservice.businesslayer.factory.ModelMapperFactory;
import iti.t3ala2ma2olk.webservice.pushnotification.QuestionNotifications;
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
public class QuestionService {

        @Autowired
    private QuestionNotifications questionNotifications;
    
    @Autowired
    private QuestionRepository questionRepository;

       private static final ModelMapper modelMapper = ModelMapperFactory.getModelMapper();

    public List<Question> getAllQuestion(Pageable pageable) {
        Page page = questionRepository.findAll(pageable);
        return page.getContent();
    }

    public ResponseEntity<?> getQuestion(Integer id) {

        if (modelMapper.map(questionRepository.findById(id).orElse(null), QuestionDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(questionRepository.findById(id).orElse(null), QuestionDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addQuestion(Question question) {


            question.setQuestionId(null);
            //   Question  has been added successfully
            questionRepository.save(question);
           //  NotificationFactory.getNotification("Question").addNewNotification(question);
           questionNotifications.addNewNotification(question);
            return new ResponseEntity<>(AddMessage.success, HttpStatus.OK);
           
        
    }

    public ResponseEntity<?> updateQuestion(Question question) {
        Question userExists = questionRepository.findById(question.getQuestionId()).orElse(null);
        if (userExists != null) {

                 questionRepository.save(question);
              //  NotificationFactory.getNotification("Question").addNewNotification(question);
               questionNotifications.addNewNotification(question);
                  return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
   
        } else {
            // There is a updateQuestion  registered with this id
            return new ResponseEntity<>(UpdateMessage.idNotFound, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteQuestion(Integer id) {
       Question question= questionRepository.findById(id).orElse(null);
        if (question!= null) {
            question.setIsdeleted(1);
              questionRepository.save(question);
            return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(DeleteMessage.fail, HttpStatus.OK);
        }
    }


}
