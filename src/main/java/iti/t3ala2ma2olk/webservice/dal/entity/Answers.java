/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abdalla
 */
@Entity
@Table(name = "answers")

@NamedQueries({
    @NamedQuery(name = "Answers.findAll", query = "SELECT a FROM Answers a")
    , @NamedQuery(name = "Answers.findByAnswersId", query = "SELECT a FROM Answers a WHERE a.answersId = :answersId")
    , @NamedQuery(name = "Answers.findByAnswer", query = "SELECT a FROM Answers a WHERE a.answer = :answer")
    , @NamedQuery(name = "Answers.findByRate", query = "SELECT a FROM Answers a WHERE a.rate = :rate")
    , @NamedQuery(name = "Answers.findByIsdeleted", query = "SELECT a FROM Answers a WHERE a.isdeleted = :isdeleted")
    , @NamedQuery(name = "Answers.findByImage", query = "SELECT a FROM Answers a WHERE a.image = :image")
    , @NamedQuery(name = "Answers.findByAudio", query = "SELECT a FROM Answers a WHERE a.audio = :audio")
    , @NamedQuery(name = "Answers.findByVideo", query = "SELECT a FROM Answers a WHERE a.video = :video")
    , @NamedQuery(name = "Answers.findByNotifi", query = "SELECT a FROM Answers a WHERE a.notifi = :notifi")
    , @NamedQuery(name = "Answers.findByAnswersDate", query = "SELECT a FROM Answers a WHERE a.answersDate = :answersDate")})
public class Answers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "answers_id")
    private Integer answersId;
    @Size(max = 4045)
    @Column(name = "answer")
    private String answer;
    @Column(name = "rate")
    private Integer rate;
    @Column(name = "isdeleted")
    private Integer isdeleted;
    @Size(max = 445)
    @Column(name = "image")
    private String image;
    @Size(max = 445)
    @Column(name = "audio")
    private String audio;
    @Size(max = 445)
    @Column(name = "video")
    private String video;
    @Column(name = "notifi")
    private Integer notifi;
    @Column(name = "answers_date")
    @Temporal(TemporalType.DATE)
    private Date answersDate;
    
//    @ManyToMany(mappedBy = "answersCollection")
//    private Collection<Person> personCollection;
    
    @OneToMany(mappedBy = "answersId")
    private Collection<NotifiAnswers> notifiAnswersCollection;
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @ManyToOne
    private Question questionId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personId;

    public Answers() {
    }

    public Answers(Integer answersId) {
        this.answersId = answersId;
    }

    public Integer getAnswersId() {
        return answersId;
    }

    public void setAnswersId(Integer answersId) {
        this.answersId = answersId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getNotifi() {
        return notifi;
    }

    public void setNotifi(Integer notifi) {
        this.notifi = notifi;
    }

    public Date getAnswersDate() {
        return answersDate;
    }

    public void setAnswersDate(Date answersDate) {
        this.answersDate = answersDate;
    }

//    @XmlTransient
//    public Collection<Person> getPersonCollection() {
//        return personCollection;
//    }
//
//    public void setPersonCollection(Collection<Person> personCollection) {
//        this.personCollection = personCollection;
//    }
 @JsonIgnore
    @XmlTransient
    public Collection<NotifiAnswers> getNotifiAnswersCollection() {
        return notifiAnswersCollection;
    }

    public void setNotifiAnswersCollection(Collection<NotifiAnswers> notifiAnswersCollection) {
        this.notifiAnswersCollection = notifiAnswersCollection;
    }
 @JsonIgnore
    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (answersId != null ? answersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answers)) {
            return false;
        }
        Answers other = (Answers) object;
        if ((this.answersId == null && other.answersId != null) || (this.answersId != null && !this.answersId.equals(other.answersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.t3ala2ma2olk.webservice.dal.entity.Answers[ answersId=" + answersId + " ]";
    }
    
}
