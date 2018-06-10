/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.aop;

import iti.t3ala2ma2olk.webservice.businesslayer.msg.RegistrationMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.UpdateMessage;
import iti.t3ala2ma2olk.webservice.dal.repository.PersonRepository;
import iti.t3ala2ma2olk.webservice.security.model.Authority;
import iti.t3ala2ma2olk.webservice.security.model.AuthorityName;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author abdalla
 */
@Aspect
@Configuration
public class UpdatePersonAspect {
     @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private PersonRepository personRepository;

    @Around("execution(* iti.t3ala2ma2olk.webservice.businesslayer.service.PersonService.updatePerson(..))")
    public Object before(ProceedingJoinPoint pjp)throws Throwable {
        //Advice
        Person person = (Person) pjp.getArgs()[0];

 Person userExists = personRepository.findById(person.getPersonId()).orElse(null);

        if (userExists != null) {

            if (((personRepository.findPersonByEmail(person.getEmail()) == null)
                    && (personRepository.findByUsername(person.getUsername()) == null))//change username & email
                    || ((userExists.getEmail().equals(person.getEmail()))
                    && (userExists.getUsername().equals(person.getUsername())))//change other data
                    ||((personRepository.findPersonByEmail(person.getEmail()) == null)
                    &&(userExists.getUsername().equals(person.getUsername())))//change email
                    ||((personRepository.findByUsername(person.getUsername()) == null)
                    &&(userExists.getEmail().equals(person.getEmail()))))//change username
            {
                
                if (!userExists.getPassword().equals(person.getPassword())) {
                    person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
                }
                
                         return pjp.proceed(new Object[] {person});

            } else if(personRepository.findPersonByEmail(person.getEmail()) != null
                    &&(userExists.getUsername().equals(person.getUsername()))){
            //   msg.setMsgBody("There is a user registered with this email or user name");
             return new ResponseEntity<>(UpdateMessage.repeatedEmail, HttpStatus.OK);

        } else{
                return new ResponseEntity<>(UpdateMessage.repeatedUsername, HttpStatus.OK);
            }
            
            
            
        } 
       return new ResponseEntity<>(UpdateMessage.fail, HttpStatus.OK);

    }
}
