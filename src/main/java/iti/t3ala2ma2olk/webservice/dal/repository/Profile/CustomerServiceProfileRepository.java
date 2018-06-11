/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.repository.Profile;

import iti.t3ala2ma2olk.webservice.dal.entity.CustomerService;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author abdalla
 */
public interface CustomerServiceProfileRepository extends CrudRepository<Person, Integer> {

    public List<Person> findByCustomerService(CustomerService customerService);

    public Page<Person> findAll(Pageable pageable);
}
