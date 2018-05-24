package iti.t3ala2ma2olk.webservice.security.repository;

import iti.t3ala2ma2olk.webservice.security.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author abdalla
 */
public interface UserRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
}
