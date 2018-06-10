/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.aop;

import iti.t3ala2ma2olk.webservice.businesslayer.msg.RegistrationMessage;
import iti.t3ala2ma2olk.webservice.dal.repository.PersonRepository;
import iti.t3ala2ma2olk.webservice.security.model.Authority;
import iti.t3ala2ma2olk.webservice.security.model.AuthorityName;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author abdalla
 */

@Aspect
@Configuration
public class RegistrationAspect {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private PersonRepository personRepository;

    @Around("execution(* iti.t3ala2ma2olk.webservice.businesslayer.service.PersonService.addPerson(..))")
    public Object before(ProceedingJoinPoint pjp)throws Throwable {
        //Advice
        Person person = (Person) pjp.getArgs()[0];

        person.setPersonId(-1);
        Person userExists = personRepository.findPersonByEmail(person.getEmail());
        if (userExists != null) {
            //  msg.setMsgBody("There is already a user registered with this email");
            return new ResponseEntity<>(RegistrationMessage.repeatedEmail, HttpStatus.OK);
        } else if (personRepository.findByUsername(person.getUsername()) != null) {
            //     msg.setMsgBody("There is already a user registered with this user name");
            return new ResponseEntity<>(RegistrationMessage.repeatedUsername, HttpStatus.OK);
        } else {
            person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
            List<Authority> authorityLsit = new ArrayList();
            authorityLsit.add(new Authority(1, AuthorityName.ROLE_USER));
            person.setAuthorities(authorityLsit);

            //     return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
            return pjp.proceed(new Object[] {person});
        }

    }
}
