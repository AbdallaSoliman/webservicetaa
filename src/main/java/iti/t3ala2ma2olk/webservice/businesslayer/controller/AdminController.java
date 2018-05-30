/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.AdminService;
import iti.t3ala2ma2olk.webservice.dal.entity.Admin;
import iti.t3ala2ma2olk.webservice.dto.AdminDTO;
import iti.t3ala2ma2olk.webservice.dto.profile.LoginProfile;
import iti.t3ala2ma2olk.webservice.dto.profile.util.DTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdalla
 */
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/Admin")
    public List<Admin> getAllAdmin(@PageableDefault(value=10, page=0) Pageable pageable) {
        return adminService.getAllAdmin(pageable);
    }

    @RequestMapping("/Admin/{id}")
    public ResponseEntity<?> getAdmin(@PathVariable Integer id) {
        return adminService.getAdmin(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Admin")
    public ResponseEntity<?> addAdmin(@DTO(AdminDTO.class) Admin admin) {
        return adminService.addAdmin(admin);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Admin")
    public ResponseEntity<?> updateAdmin(@DTO(AdminDTO.class) Admin admin) {
        return adminService.updateAdmin(admin);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Admin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Integer id) {
        return adminService.deleteAdmin(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Admin/Login")
    public ResponseEntity<?> login(@DTO(LoginProfile.class) Admin admin) {
        return adminService.login(admin);
    }
}
