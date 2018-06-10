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
import org.modelmapper.ModelMapper;
import iti.t3ala2ma2olk.webservice.businesslayer.factory.ModelMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class ReportProfileService {

       private static final ModelMapper modelMapper = ModelMapperFactory.getModelMapper();
    @Autowired
    private ReportProfileRepository reportRepository;

    @Deprecated
    public List<ReportProfile> getAllUserProfile() {

        List<Report> reportList = new ArrayList<>();
        List<ReportProfile> reportProfileList = new ArrayList<>();

        reportRepository.findAll().forEach(reportList::add);

        reportList.stream()
                .forEach(report -> reportProfileList.add(new ReportProfile(report.getReportId(), report.getMsg())));

        return reportProfileList;
    }

    public List<ReportProfile> getAllUserProfile(Pageable pageable) {
        Page page = reportRepository.findAll(pageable);
        List<Report> reportList = page.getContent();
        List<ReportProfile> reportProfileList = new ArrayList<>();

        reportList.stream()
                .forEach(report -> reportProfileList.add(modelMapper.map(report, ReportProfile.class)));

        return reportProfileList;
    }
}
