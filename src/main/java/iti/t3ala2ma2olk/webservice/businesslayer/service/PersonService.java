/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;


import iti.t3ala2ma2olk.webservice.businesslayer.msg.DeleteMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.FindMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.LoginMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.RegistrationMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.UpdateMessage;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import iti.t3ala2ma2olk.webservice.dal.repository.PersonRepository;
import iti.t3ala2ma2olk.webservice.dto.PersonDTO;
import iti.t3ala2ma2olk.webservice.security.model.Authority;
import iti.t3ala2ma2olk.webservice.security.model.AuthorityName;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class PersonService {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPerson(Pageable pageable) {
        Page page = personRepository.findAll(pageable);
        return page.getContent();
    }

    public ResponseEntity<?> getPerson(Integer id) {

        if (modelMapper.map(personRepository.findById(id).orElse(null), PersonDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(personRepository.findById(id).orElse(null), PersonDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addPerson(Person person) {
        person.setPersonId(null);
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
            //   msg.setMsgBody("User has been registered successfully");
            personRepository.save(person);
            return new ResponseEntity<>(RegistrationMessage.success, HttpStatus.OK);
        }

    }

    public ResponseEntity<?> updatePerson(Person person) {
        Person userExists = personRepository.findById(person.getPersonId()).orElse(null);

        if (userExists != null) {

            if (((personRepository.findPersonByEmail(person.getEmail()) == null)
                    && (personRepository.findByUsername(person.getUsername()) == null))
                    || ((userExists.getEmail().equals(person.getEmail()))
                    && (userExists.getUsername().equals(person.getUsername())))) {
                if (!userExists.getPassword().equals(person.getPassword())) {
                    person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
                }
                //   msg.setMsgBody("User has been updated successfully ");
                       personRepository.save(person);
                  return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
          

            }
        } else if(personRepository.findPersonByEmail(person.getEmail()) != null){
            //   msg.setMsgBody("There is a user registered with this email or user name");
             return new ResponseEntity<>(UpdateMessage.repeatedEmail, HttpStatus.OK);

        }
       return new ResponseEntity<>(UpdateMessage.repeatedUsername, HttpStatus.OK);
    }

    public ResponseEntity<?> deletePerson(Integer id) {
        personRepository.deleteById(id);
        return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
    }

    public ResponseEntity<?> login(Person person) {
        if (personRepository.findByUsername(person.getUsername()) != null) {
            return new ResponseEntity<>(modelMapper.map(personRepository.findByUsername(person.getUsername()), PersonDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(LoginMessage.fail, HttpStatus.OK);
        }
    }

}
