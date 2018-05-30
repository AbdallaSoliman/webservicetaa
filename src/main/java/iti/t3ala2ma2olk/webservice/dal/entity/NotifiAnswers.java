/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.entity;

import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abdalla
 */
@Entity
@Table(name = "notifi_answers")

@NamedQueries({
    @NamedQuery(name = "NotifiAnswers.findAll", query = "SELECT n FROM NotifiAnswers n")
    , @NamedQuery(name = "NotifiAnswers.findByNotifiId", query = "SELECT n FROM NotifiAnswers n WHERE n.notifiId = :notifiId")
    , @NamedQuery(name = "NotifiAnswers.findByState", query = "SELECT n FROM NotifiAnswers n WHERE n.state = :state")})
public class NotifiAnswers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notifi_id")
    private Integer notifiId;
    @Column(name = "state")
    private Integer state;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personId;
    @JoinColumn(name = "answers_id", referencedColumnName = "answers_id")
    @ManyToOne
    private Answers answersId;

    public NotifiAnswers() {
    }

    public NotifiAnswers(Integer notifiId) {
        this.notifiId = notifiId;
    }

    public Integer getNotifiId() {
        return notifiId;
    }

    public void setNotifiId(Integer notifiId) {
        this.notifiId = notifiId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Answers getAnswersId() {
        return answersId;
    }

    public void setAnswersId(Answers answersId) {
        this.answersId = answersId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notifiId != null ? notifiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotifiAnswers)) {
            return false;
        }
        NotifiAnswers other = (NotifiAnswers) object;
        if ((this.notifiId == null && other.notifiId != null) || (this.notifiId != null && !this.notifiId.equals(other.notifiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.t3ala2ma2olk.webservice.dal.entity.NotifiAnswers[ notifiId=" + notifiId + " ]";
    }
    
}
