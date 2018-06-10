/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.Report;
import iti.t3ala2ma2olk.webservice.dal.repository.ReportRepository;
import iti.t3ala2ma2olk.webservice.dto.ReportDTO;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.AddMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.DeleteMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.FindMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.LoginMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.RegistrationMessage;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.UpdateMessage;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import iti.t3ala2ma2olk.webservice.businesslayer.factory.ModelMapperFactory;
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
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

       private static final ModelMapper modelMapper = ModelMapperFactory.getModelMapper();

    public List<Report> getAllReport(Pageable pageable) {
        Page page = reportRepository.findAll(pageable);
        return page.getContent();
    }

    public ResponseEntity<?> getReport(Integer id) {

        if (modelMapper.map(reportRepository.findById(id).orElse(null), ReportDTO.class) != null) {
            return new ResponseEntity<>(modelMapper.map(reportRepository.findById(id).orElse(null), ReportDTO.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(FindMessage.fail, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> addReport(Report report) {


            report.setReportId(null);
            //   Report  has been added successfully
            reportRepository.save(report);
            return new ResponseEntity<>(AddMessage.success, HttpStatus.OK);
        
    }

    public ResponseEntity<?> updateReport(Report report) {
        Report userExists = reportRepository.findById(report.getReportId()).orElse(null);
        if (userExists != null) {

                 reportRepository.save(report);
                  return new ResponseEntity<>(UpdateMessage.success, HttpStatus.OK);
   
        } else {
            // There is a updateReport  registered with this id
            return new ResponseEntity<>(UpdateMessage.idNotFound, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteReport(Integer id) {
        reportRepository.deleteById(id);
        return new ResponseEntity<>(DeleteMessage.success, HttpStatus.OK);
    }


}
