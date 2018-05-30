/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.profile;


import iti.t3ala2ma2olk.webservice.dal.repository.Profile.TaaUserProfileRepository;
import iti.t3ala2ma2olk.webservice.dto.profile.TaaUserProfile;
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
public class TaaUserProfileService {

    
        private static final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private TaaUserProfileRepository taaUserRepository;

    public List<TaaUserProfile> getAllUserProfile() {

        List<Person> persontList = new ArrayList<>();
        List<TaaUserProfile> taaUserList = new ArrayList<>();

        taaUserRepository.findAll().forEach(persontList::add);
        
        persontList.stream()
                .filter(s -> (s.getTaaUser() != null))
                .forEach(taaUser->taaUserList.add(new TaaUserProfile(taaUser.getPersonId(),taaUser.getFirst())));

        return taaUserList;
    }
    public List<TaaUserProfile> getAllUserProfile(Pageable pageable) {
        Page page = taaUserRepository.findAll(pageable);
        List<Person> personList = page.getContent();
        List<TaaUserProfile> taaUserProfileList = new ArrayList<>();

        personList.stream()
                .forEach(person -> taaUserProfileList.add(modelMapper.map(person, TaaUserProfile.class)));

        return taaUserProfileList;
    }
}
