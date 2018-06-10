/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.repository;

import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author abdalla
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
    //  Person findByUsername(String username);

    public Person findPersonByEmail(String email);

    public Person findByUsername(String username);

    public Person findByUsernameAndPassword(String username, String password);
//    public  List<Person> findByTaaUser(null);

    public Page findAll(Pageable pageable);

//    public Integer findAnswersIdByUsername(String username);
}
