/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller;

import iti.t3ala2ma2olk.webservice.businesslayer.service.ReportService;
import iti.t3ala2ma2olk.webservice.dal.entity.Report;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    
        @RequestMapping("/getReport")       
    public List<Report> getAllReport(){
        return reportService.getAllReport();
    }
    @RequestMapping("/getReport/{id}")  
    public Report getReport(@PathVariable Integer id){
        return reportService.getReport(id);
    }
    @RequestMapping(method = RequestMethod.POST,value= "/getReport") 
    public void addReport(@RequestBody Report  report){
        reportService.addReport(report);
    }
        @RequestMapping(method = RequestMethod.PUT,value= "/getReport") 
    public void updateReport(@RequestBody Report  report){
        reportService.updateReport(report);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= "/getReport/{id}")  
    public void deleteReport(@PathVariable Integer id){
         reportService.deleteReport(id);
    }
}
