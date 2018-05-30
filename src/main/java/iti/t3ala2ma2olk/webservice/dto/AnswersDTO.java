/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iti.t3ala2ma2olk.webservice.dal.entity.NotifiAnswers;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */

@Getter
@Setter
public class AnswersDTO {

    public AnswersDTO() {
    }
    

    private Integer answersId;

    private String answer;
    private Integer rate;
    private Integer isdeleted;

    private String image;

    private String audio;

    private String video;
    private Integer notifi;
    private Date answersDate;
       
 //@JsonIgnore
    private Collection<NotifiAnswers> notifiAnswersCollection;
// @JsonIgnore
    private Question questionId;

    private Person personId;
}
