/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.profile;

import iti.t3ala2ma2olk.webservice.dal.entity.Report;
import iti.t3ala2ma2olk.webservice.dal.repository.Profile.ReportProfileRepository;
import iti.t3ala2ma2olk.webservice.dto.profile.ReportProfile;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class ReportProfileService {
        
    @Autowired
    private ReportProfileRepository reportRepository;

    public List<ReportProfile> getAllUserProfile() {

        List<Report> reportList = new ArrayList<>();
        List<ReportProfile> reportProfileList = new ArrayList<>();

        reportRepository.findAll().forEach(reportList::add);
        
        reportList.stream()
                .forEach(reportProfile->reportProfileList.add(new ReportProfile(reportProfile.getReportId(),reportProfile.getMsg())));

        return reportProfileList;
    }
}
