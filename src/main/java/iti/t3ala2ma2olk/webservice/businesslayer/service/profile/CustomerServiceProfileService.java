/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.profile;

import iti.t3ala2ma2olk.webservice.businesslayer.factory.ModelMapperFactory;
import iti.t3ala2ma2olk.webservice.dal.repository.Profile.CustomerServiceProfileRepository;
import iti.t3ala2ma2olk.webservice.dto.profile.CustomerServiceProfile;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class CustomerServiceProfileService {

    private static final ModelMapper modelMapper = ModelMapperFactory.getModelMapper();
    @Autowired
    private CustomerServiceProfileRepository customerServiceRepository;

    public List<CustomerServiceProfile> getAllUserProfile() {

        List<Person> persontList = new ArrayList<>();
        List<CustomerServiceProfile> customerServiceList = new ArrayList<>();

        customerServiceRepository.findAll().forEach(persontList::add);

        persontList.stream()
                .filter(s -> (s.getCustomerService() != null))
                .forEach(customerService -> customerServiceList.add(new CustomerServiceProfile(customerService.getPersonId(), customerService.getFirst())));

        return customerServiceList;
    }

    public List<CustomerServiceProfile> getAllUserProfile(Pageable pageable) {
        Page page = customerServiceRepository.findAll(pageable);
        List<Person> personList = page.getContent();
        List<CustomerServiceProfile> customerServiceProfileList = new ArrayList<>();

        personList.stream().filter(predicate -> predicate.getCustomerService() != null)
                .forEach(person -> customerServiceProfileList.add(modelMapper.map(person, CustomerServiceProfile.class)));

        return customerServiceProfileList;
    }


}
