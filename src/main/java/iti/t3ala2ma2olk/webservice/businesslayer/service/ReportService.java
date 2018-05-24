/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.Report;
import iti.t3ala2ma2olk.webservice.dal.repository.ReportRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class ReportService {
        @Autowired
    private ReportRepository reportRepository;
    
     public List<Report> getAllReport(){
            List<Report> myIntList= new ArrayList<>();
            reportRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }
    public  Report getReport(Integer id){
            return reportRepository.findById(id).orElse(null);
    }

    public void addReport(Report topic) {
        reportRepository.save(topic);
   }

    public void updateReport(Report topic) {
             reportRepository.save(topic);
    }

   public void deleteReport(Integer id) {
         reportRepository.deleteById(id);
    }
    
}
