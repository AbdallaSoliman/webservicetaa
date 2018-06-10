/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto;

import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.dal.entity.SubCat;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */
@Getter
@Setter
public class QuestionDTO {

    
    
    private Integer questionId;

    private String title;

    private String body;

    private String image;

    private String audio;

    private String video;

    private Integer rate;

    private Integer verified;

    private Integer isdeleted;

    private Integer notifi;    

    private Date questionDate;

    private Integer closed;
  
    private Collection<SubCat> subCatCollection;
  
    private Collection<Person> personRateCollection;

    private Person personId;

    private Collection<Answers> answersCollection;

    public QuestionDTO() {
    }
    
}
