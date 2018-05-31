/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.Admin;
import iti.t3ala2ma2olk.webservice.dal.repository.AdminRepository;
import iti.t3ala2ma2olk.webservice.dto.AdminDTO;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.AddMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.DeleteMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.FindMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.LoginMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.RegistrationMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.UpdateMessage;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class AdminService {

    private static final ModelMapper modelMapper = new ModelMapper();
    /* using to encode Password to be secur*/
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmin(Pageable pageable) {
        Page page = adminRepository.findAll(pageable);
        return page.getContent();
    }

    public ResponseEntity<?> getAdmin(Integer id) {

        if (modelMapper.map(adminRepository.findById(id).orElse(null), AdminDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(adminRepository.findById(id).orElse(null), AdminDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addAdmin(Admin admin) {

        if (adminRepository.findByUsername(admin.getUsername()) != null) {
            //     There is already a user registered with this user name
            return new ResponseEntity<>(RegistrationMessage.fail, HttpStatus.OK);
        } else {
            admin.setAdminId(null);
           // admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
            admin.setPassword(admin.getPassword());
            //   User has been registered successfully
            adminRepository.save(admin);
            return new ResponseEntity<>(AddMessage.success, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> updateAdmin(Admin admin) {
        Admin userExists = adminRepository.findById(admin.getAdminId()).orElse(null);
        if (userExists != null) {
            if (((adminRepository.findByUsername(admin.getUsername()) == null))
                    || ((userExists.getUsername().equals(admin.getUsername())))) {
                if (!userExists.getPassword().equals(admin.getPassword())) {
                //    admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
                     admin.setPassword(admin.getPassword());
                }
                //   User has been updated successfully 
                adminRepository.save(admin);
                return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(UpdateMessage.repeatedUsername, HttpStatus.OK);
            }
        } else {
            // There is a user registered with this id
            return new ResponseEntity<>(UpdateMessage.idNotFound, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
        return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
    }

    public ResponseEntity<?> login(Admin admin) {
        if (adminRepository.findByUsername(admin.getUsername()) != null) {
            return new ResponseEntity<>(modelMapper.map(adminRepository.findByUsername(admin.getUsername()), AdminDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(LoginMessage.fail, HttpStatus.OK);
        }
    }

}
