/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.NotifiAnswersService;
import iti.t3ala2ma2olk.webservice.dal.entity.NotifiAnswers;
import iti.t3ala2ma2olk.webservice.dal.entity.NotifiAnswers;
import iti.t3ala2ma2olk.webservice.dto.NotifiAnswersDTO;
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
public class NotifiAnswersController {

    @Autowired
    private NotifiAnswersService notifiAnswersService;

    @RequestMapping("/NotifiAnswers")
    public List<NotifiAnswers> getAllNotifiAnswers(@PageableDefault(value=10, page=0) Pageable pageable) {
        return notifiAnswersService.getAllNotifiAnswers(pageable);
    }

    @RequestMapping("/NotifiAnswers/{id}")
    public ResponseEntity<?> getNotifiAnswers(@PathVariable Integer id) {
        return notifiAnswersService.getNotifiAnswers(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/NotifiAnswers")
    public ResponseEntity<?> addNotifiAnswers(@DTO(NotifiAnswersDTO.class) NotifiAnswers notifiAnswers) {
        return notifiAnswersService.addNotifiAnswers(notifiAnswers);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/NotifiAnswers")
    public ResponseEntity<?> updateNotifiAnswers(@DTO(NotifiAnswersDTO.class) NotifiAnswers notifiAnswers) {
        return notifiAnswersService.updateNotifiAnswers(notifiAnswers);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/NotifiAnswers/{id}")
    public ResponseEntity<?> deleteNotifiAnswers(@PathVariable Integer id) {
        return notifiAnswersService.deleteNotifiAnswers(id);
    }

}
