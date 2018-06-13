/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.repository.AnswersRepository;
import iti.t3ala2ma2olk.webservice.dto.AnswersDTO;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.AddMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.DeleteMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.FindMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.UpdateMessage;
import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.dal.repository.AnswersRepository;
import iti.t3ala2ma2olk.webservice.pushnotification.NotificationFactory;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import iti.t3ala2ma2olk.webservice.businesslayer.factory.ModelMapperFactory;
import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.pushnotification.AnswersNotifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
public class AnswersService {

    @Autowired
    private AnswersNotifications answersNotifications;

    @Autowired
    private AnswersRepository answersRepository;

    private static final ModelMapper modelMapper = ModelMapperFactory.getModelMapper();

    public List<Answers> getAllAnswers(Pageable pageable) {
        //abdalla start
        List<Answers> list = new ArrayList();
        List<Answers> filteredlist = new ArrayList();

        answersRepository.findAll().forEach(list::add);
        list.stream().filter(predicate -> predicate.getIsdeleted() == 0).forEach(filteredlist::add);
        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > filteredlist.size() ? filteredlist.size() : (start + pageable.getPageSize());
        Page<Answers> pages = new PageImpl<Answers>(filteredlist.subList(start, end), pageable, filteredlist.size());

        return pages.getContent();
        //abdalla end

    }

    public ResponseEntity<?> getAnswers(Integer id) {

        if (modelMapper.map(answersRepository.findById(id).orElse(null), AnswersDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(answersRepository.findById(id).orElse(null), AnswersDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addAnswers(Answers answers) {

        answers.setAnswersId(null);
        answers.setIsdeleted(0);
        //   User has been added successfully
        answersRepository.save(answers);
//            NotificationFactory.getNotification("Answers").addNewNotification(answers);
        answersNotifications.addNewNotification(answers);
        return new ResponseEntity<>(AddMessage.success, HttpStatus.OK);

    }

    public ResponseEntity<?> updateAnswers(Answers answers) {
        Answers userExists = answersRepository.findById(answers.getAnswersId()).orElse(null);
        if (userExists != null) {
            //   answers has been updated successfully 
            answersRepository.save(answers);
//                NotificationFactory.getNotification("Answers").addNewNotification(answers);
            answersNotifications.addNewNotification(answers);
            return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
        }

        return new ResponseEntity<>(UpdateMessage.fail, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteAnswers(Integer id) {
        Answers answers = answersRepository.findById(id).orElse(null);
        if (answers != null) {
            answers.setIsdeleted(1);
            answersRepository.save(answers);
            return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(DeleteMessage.fail, HttpStatus.OK);
        }
    }

}
