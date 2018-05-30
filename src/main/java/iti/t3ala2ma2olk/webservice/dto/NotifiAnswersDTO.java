/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto;

import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */
@Getter
@Setter
public class NotifiAnswersDTO {

    public NotifiAnswersDTO() {
    }

    
    
    private Integer notifiId;

    private Integer state;

    private Person personId;

    private Answers answersId;
}
