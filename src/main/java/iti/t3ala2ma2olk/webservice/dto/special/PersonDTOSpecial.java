/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto.special;

import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.dal.entity.CustomerService;
import iti.t3ala2ma2olk.webservice.dal.entity.NotifiAnswers;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dal.entity.Report;
import iti.t3ala2ma2olk.webservice.dal.entity.TaaUser;
import iti.t3ala2ma2olk.webservice.security.model.Authority;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Alzantot
 */
@Getter
@Setter
public class PersonDTOSpecial {
    
    public PersonDTOSpecial() {
    }
    private static final long serialVersionUID = 1L;

    
    
    private Integer personId;

    private String image;

    private String first;

    private String last;

    private String password;

    private String email;

    private String type;

    private String gender;
    private boolean enabled;

    private String username;

    private Date lastPasswordResetDate;

    private List<Authority> authorities;

    private Collection<Answers> answersCollection;

    private Collection<Question> questionCollection;

    private Collection<NotifiAnswers> notifiAnswersCollection;

    private Collection<Report> reportCollection;

    private CustomerService customerService;

    private TaaUser taaUser;

    private Integer numOfAskedQuestions;
}
