/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.businesslayer.msg.RegistrationMassage;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import iti.t3ala2ma2olk.webservice.dal.repository.PersonRepository;
import iti.t3ala2ma2olk.webservice.dto.UserProfile;
import iti.t3ala2ma2olk.webservice.security.model.Authority;
import iti.t3ala2ma2olk.webservice.security.model.AuthorityName;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class PersonService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPerson() {
        List<Person> myIntList = new ArrayList<>();
        personRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }

    public Person getPerson(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person addPerson(Person person) {
        Person userExists = personRepository.findPersonByEmail(person.getEmail());
        RegistrationMassage msg = new RegistrationMassage();
        if (userExists != null) {
            msg.setMsgBody("There is already a user registered with this email");
            return null;
        } else if(personRepository.findByUsername(person.getUsername()) != null){
                msg.setMsgBody("There is already a user registered with this user name");
            return null;
        }else{
            person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
            List <Authority> authorityLsit = new ArrayList();
            authorityLsit.add(new Authority(1,AuthorityName.ROLE_USER));
            person.setAuthorities(authorityLsit);
            msg.setMsgBody("User has been registered successfully");
            return personRepository.save(person);
        }

    }

    public Person updatePerson(Person person) {
        Person userExists = personRepository.findById(person.getPersonId()).orElse(null);
        RegistrationMassage msg = new RegistrationMassage();
        if (userExists != null) {

            if (((personRepository.findPersonByEmail(person.getEmail()) == null)
                    && (personRepository.findByUsername(person.getUsername()) == null))
                        || ((userExists.getEmail().equals(person.getEmail()))
                              && (userExists.getUsername().equals(person.getUsername())))) {
                if (!userExists.getPassword().equals(person.getPassword())) {
                    person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
                }
                msg.setMsgBody("User has been updated successfully ");
                return personRepository.save(person);

            }
        } else {
            msg.setMsgBody("There is a user registered with this email or user name");

        }
        return null;
    }

//    public List<UserProfile> loginPerson() {

//    public List<UserProfile> getAllUserProfile(){
//        
////             List<Person> myIntList = new ArrayList<>();
////        personRepository.findAll().forEach(myIntList::add);
////       for( myIntList in i){
////           
////       }
////        
////        return myIntList; 
//    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    public Person loginPerson(Person person) {
        return personRepository.findByUsernameAndPassword(person.getUsername(), person.getPassword());
    }

}
