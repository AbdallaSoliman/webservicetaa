/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.special;

import iti.t3ala2ma2olk.webservice.businesslayer.msg.RateMessage;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dal.repository.QuestionRepository;
import iti.t3ala2ma2olk.webservice.dal.repository.PersonRepository;
import iti.t3ala2ma2olk.webservice.security.TokenHandler;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class RateQuestionService {

   @Autowired
    TokenHandler tokenHandler;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<?> questionRateUp(HttpServletRequest request, Integer id) {
        Person person = tokenHandler.getCurrentPerson(request);
        System.out.println("10_6 id" + id);
        Question question = questionRepository.findById(id).orElse(null);
//        Person person = personRepository.findById(id).orElse(null);

        if (!question.getPersonRateCollection().contains(person)) {
            if (question.getRate() != null) {
                question.setRate(question.getRate() + 1);
            } else {
                question.setRate(0);
            }
//             question.getPersonCollection().add(person);
            Collection<Question> questionList = person.getQuestionCollection();
            questionList.add(question);
            person.setQuestionCollection(questionList);

            questionRepository.save(question);
            return new ResponseEntity<>(RateMessage.success, HttpStatus.OK);
        }

        return new ResponseEntity<>(RateMessage.repeated, HttpStatus.OK);
    }

    public ResponseEntity<?> questionRateDown(HttpServletRequest request, Integer id) {
        Person person = tokenHandler.getCurrentPerson(request);
         Question question = questionRepository.findById(id).orElse(null);
        if (!question.getPersonRateCollection().contains(person)) {
            if (question.getRate() != null) {
                question.setRate(question.getRate() - 1);
            } else {
                question.setRate(0);
            }
//             question.getPersonCollection().add(person);
            Collection<Question> questionList = person.getQuestionCollection();
            questionList.add(question);
            person.setQuestionCollection(questionList);

            questionRepository.save(question);
            return new ResponseEntity<>(RateMessage.success, HttpStatus.OK);
        }
        return new ResponseEntity<>(RateMessage.repeated, HttpStatus.OK);
    }

    public ResponseEntity<?> questionRateUpRemove(HttpServletRequest request, Integer id) {
        Person person = tokenHandler.getCurrentPerson(request);
        Question question = questionRepository.findById(id).orElse(null);
        if (question.getPersonRateCollection().contains(person)) {
            if (question.getRate() != null) {
                question.setRate(question.getRate() - 1);
            } else {
                 return new ResponseEntity<>(RateMessage.deleteFail, HttpStatus.OK);
            }
//             question.getPersonCollection().add(person);
            Collection<Question> questionList = person.getQuestionCollection();
            questionList.add(question);
            person.setQuestionCollection(questionList);

            questionRepository.save(question);
            return new ResponseEntity<>(RateMessage.success, HttpStatus.OK);
        }
        return new ResponseEntity<>(RateMessage.deleteFail, HttpStatus.OK);
    }

    public ResponseEntity<?> questionRateDownRemove(HttpServletRequest request, Integer id) {
        Person person = tokenHandler.getCurrentPerson(request);
        Question question = questionRepository.findById(id).orElse(null);
        if (question.getPersonRateCollection().contains(person)) {
            if (question.getRate() != null) {
                question.setRate(question.getRate() + 1);
            } else {
                   return new ResponseEntity<>(RateMessage.deleteFail, HttpStatus.OK);
            }
//             question.getPersonCollection().add(person);
            Collection<Question> questionList = person.getQuestionCollection();
            questionList.add(question);
            person.setQuestionCollection(questionList);

            questionRepository.save(question);
            return new ResponseEntity<>(RateMessage.success, HttpStatus.OK);
        }
        return new ResponseEntity<>(RateMessage.deleteFail, HttpStatus.OK);
    }
    
}
