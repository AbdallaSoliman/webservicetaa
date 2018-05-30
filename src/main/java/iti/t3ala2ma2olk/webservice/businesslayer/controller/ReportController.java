/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.ReportService;
import iti.t3ala2ma2olk.webservice.dal.entity.Report;
import iti.t3ala2ma2olk.webservice.dal.entity.Report;
import iti.t3ala2ma2olk.webservice.dto.ReportDTO;
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
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/Report")
    public List<Report> getAllReport(@PageableDefault(value=10, page=0) Pageable pageable) {
        return reportService.getAllReport(pageable);
    }

    @RequestMapping("/Report/{id}")
    public ResponseEntity<?> getReport(@PathVariable Integer id) {
        return reportService.getReport(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Report")
    public ResponseEntity<?> addReport(@DTO(ReportDTO.class) Report report) {
        return reportService.addReport(report);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Report")
    public ResponseEntity<?> updateReport(@DTO(ReportDTO.class) Report report) {
        return reportService.updateReport(report);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Report/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable Integer id) {
        return reportService.deleteReport(id);
    }

}
