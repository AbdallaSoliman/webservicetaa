/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.businesslayer.factory.MessageFactory;
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
import iti.t3ala2ma2olk.webservice.businesslayer.msg.MessageDTO;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.QuestionIdDTO;
import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.pushnotification.QuestionNotifications;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;
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
public class QuestionService {

    @Autowired
    private QuestionNotifications questionNotifications;

    @Autowired
    private QuestionRepository questionRepository;

    private static final ModelMapper modelMapper = ModelMapperFactory.getModelMapper();

    public List<Question> getAllQuestion(Pageable pageable) {
        //abdalla start
        List<Question> list = new ArrayList();
        List<Question> filteredlist = new ArrayList();

        questionRepository.findAll().forEach(list::add);
        list.stream().filter(predicate -> predicate.getIsdeleted() == 0).forEach(filteredlist::add);
        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > filteredlist.size() ? filteredlist.size() : (start + pageable.getPageSize());
        Page<Question> pages = new PageImpl<Question>(filteredlist.subList(start, end), pageable, filteredlist.size());

        return pages.getContent();
        //abdalla end
    }

    public ResponseEntity<?> getQuestion(Integer id) {
        //abdalla start
        QuestionDTO questionDTO = new QuestionDTO();
        List<Answers> filteredlist = new ArrayList();
        questionDTO = modelMapper.map(questionRepository.findById(id).orElse(null), QuestionDTO.class);
        //abdalla end
        if (questionDTO != null) {

            if (questionDTO.getAnswersCollection() != null) {
                questionDTO.getAnswersCollection().stream().filter(predicate -> predicate.getIsdeleted() == 0).forEach(filteredlist::add);
                questionDTO.setAnswersCollection(filteredlist);
            }
            return new ResponseEntity<>(questionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addQuestion(Question question) {

        question.setQuestionId(null);
        question.setIsdeleted(0);
        question.setClosed(0);
        question.setQuestionDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        question.setVerified(0);
        //   Question  has been added successfully
        Question result = questionRepository.save(question);
        //  NotificationFactory.getNotification("Question").addNewNotification(question);
        questionNotifications.addNewNotification(result);
        
        QuestionIdDTO questionIdDTO = MessageFactory.getQuestionIdDTO(result.getQuestionId());
        return new ResponseEntity<>(questionIdDTO, HttpStatus.OK);

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
        Question question = questionRepository.findById(id).orElse(null);
        if (question != null) {
            question.setIsdeleted(1);
            questionRepository.save(question);
            return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(DeleteMessage.fail, HttpStatus.OK);
        }
    }

}
