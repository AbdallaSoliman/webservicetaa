/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.special;

import iti.t3ala2ma2olk.webservice.businesslayer.msg.RateMessage;
import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.dal.repository.PersonRepository;
import iti.t3ala2ma2olk.webservice.dal.repository.AnswersRepository;
import iti.t3ala2ma2olk.webservice.security.TokenHandler;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author abdalla
 */
@Service
public class RateAnswerService {

    @Autowired
    TokenHandler tokenHandler;

    @Autowired
    private AnswersRepository answersRepository;

    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<?> answersRateUp(HttpServletRequest request, Integer id) {
        Person person = tokenHandler.getCurrentPerson(request);
        System.out.println("10_6 id" + id);
        Answers answers = answersRepository.findById(id).orElse(null);
//        Person person = personRepository.findById(id).orElse(null);
        System.out.println("10_6" + answers.getAnswer());
        System.out.println("10_6" + person.getEmail());
        System.out.println("10_6" + answers.getPersonCollection().size());
        if (!answers.getPersonCollection().contains(person)) {
            if (answers.getRate() != null) {
                answers.setRate(answers.getRate() + 1);
            } else {
                answers.setRate(0);
            }
//             answers.getPersonCollection().add(person);
            Collection<Answers> answersList = person.getAnswersCollection();
            answersList.add(answers);
            person.setAnswersCollection(answersList);

            answersRepository.save(answers);
            return new ResponseEntity<>(RateMessage.success, HttpStatus.OK);
        }

        return new ResponseEntity<>(RateMessage.repeated, HttpStatus.OK);
    }

    public ResponseEntity<?> answersRateDown(HttpServletRequest request, Integer id) {
        Person person = tokenHandler.getCurrentPerson(request);
         Answers answers = answersRepository.findById(id).orElse(null);
        if (!answers.getPersonCollection().contains(person)) {
            if (answers.getRate() != null) {
                answers.setRate(answers.getRate() - 1);
            } else {
                answers.setRate(0);
            }
//             answers.getPersonCollection().add(person);
            Collection<Answers> answersList = person.getAnswersCollection();
            answersList.add(answers);
            person.setAnswersCollection(answersList);

            answersRepository.save(answers);
            return new ResponseEntity<>(RateMessage.success, HttpStatus.OK);
        }
        return new ResponseEntity<>(RateMessage.repeated, HttpStatus.OK);
    }

    public ResponseEntity<?> answersRateUpRemove(HttpServletRequest request, Integer id) {
        Person person = tokenHandler.getCurrentPerson(request);
        Answers answers = answersRepository.findById(id).orElse(null);
        if (answers.getPersonCollection().contains(person)) {
            if (answers.getRate() != null) {
                answers.setRate(answers.getRate() - 1);
            } else {
                 return new ResponseEntity<>(RateMessage.deleteFail, HttpStatus.OK);
            }
//             answers.getPersonCollection().add(person);
            Collection<Answers> answersList = person.getAnswersCollection();
            answersList.add(answers);
            person.setAnswersCollection(answersList);

            answersRepository.save(answers);
            return new ResponseEntity<>(RateMessage.success, HttpStatus.OK);
        }
        return new ResponseEntity<>(RateMessage.deleteFail, HttpStatus.OK);
    }

    public ResponseEntity<?> answersRateDownRemove(HttpServletRequest request, Integer id) {
        Person person = tokenHandler.getCurrentPerson(request);
        Answers answers = answersRepository.findById(id).orElse(null);
        if (answers.getPersonCollection().contains(person)) {
            if (answers.getRate() != null) {
                answers.setRate(answers.getRate() + 1);
            } else {
                   return new ResponseEntity<>(RateMessage.deleteFail, HttpStatus.OK);
            }
//             answers.getPersonCollection().add(person);
            Collection<Answers> answersList = person.getAnswersCollection();
            answersList.add(answers);
            person.setAnswersCollection(answersList);

            answersRepository.save(answers);
            return new ResponseEntity<>(RateMessage.success, HttpStatus.OK);
        }
        return new ResponseEntity<>(RateMessage.deleteFail, HttpStatus.OK);
    }
}
