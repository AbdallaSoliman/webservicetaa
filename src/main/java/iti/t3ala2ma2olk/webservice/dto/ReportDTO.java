/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto;

import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */
@Getter
@Setter
public class ReportDTO {

    public ReportDTO() {
    }
  
    
    
    private Integer reportId;

    private String msg;
    
    private String title;

    private String type;

    private Date reportDate;

    private Integer checked;

    private Integer action;

    private Person personId;
}
