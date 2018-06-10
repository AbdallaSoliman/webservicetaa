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
import iti.t3ala2ma2olk.webservice.businesslayer.factory.ModelMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private static final ModelMapper modelMapper = ModelMapperFactory.getModelMapper();

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
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
    }

    public ResponseEntity<?> updatePerson(Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
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
