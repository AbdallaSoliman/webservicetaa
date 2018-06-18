/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.special;

import iti.t3ala2ma2olk.webservice.businesslayer.factory.ModelMapperFactory;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.FindMessage;
import iti.t3ala2ma2olk.webservice.dal.repository.PersonRepository;
import iti.t3ala2ma2olk.webservice.dto.PersonDTO;
import iti.t3ala2ma2olk.webservice.dto.special.PersonDTOSpecial;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alzantot
 */

@Service
public class PersonSpecialService {
    private static final ModelMapper modelMapper = ModelMapperFactory.getModelMapper();

       @Autowired
    private PersonRepository personRepository;


    public ResponseEntity<?> getPerson(Integer id) {

        Person person=personRepository.findById(id).orElse(null);
       
        PersonDTOSpecial personDTO=modelMapper.map(personRepository.findById(id).orElse(null), PersonDTOSpecial.class);
        personDTO.setNumOfAskedQuestions(person.getAskedQuestionCollection().size());
        
        if (personDTO != null) {
            return new ResponseEntity<>(personDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }
    
}
