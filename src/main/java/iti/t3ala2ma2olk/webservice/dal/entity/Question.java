/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author abdalla
 */
@Entity
@Indexed
@Table(name = "question")

@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
    , @NamedQuery(name = "Question.findByQuestionId", query = "SELECT q FROM Question q WHERE q.questionId = :questionId")
    , @NamedQuery(name = "Question.findByTitle", query = "SELECT q FROM Question q WHERE q.title = :title")
    , @NamedQuery(name = "Question.findByBody", query = "SELECT q FROM Question q WHERE q.body = :body")
    , @NamedQuery(name = "Question.findByImage", query = "SELECT q FROM Question q WHERE q.image = :image")
    , @NamedQuery(name = "Question.findByAudio", query = "SELECT q FROM Question q WHERE q.audio = :audio")
    , @NamedQuery(name = "Question.findByVideo", query = "SELECT q FROM Question q WHERE q.video = :video")
    , @NamedQuery(name = "Question.findByRate", query = "SELECT q FROM Question q WHERE q.rate = :rate")
    , @NamedQuery(name = "Question.findByVerified", query = "SELECT q FROM Question q WHERE q.verified = :verified")
    , @NamedQuery(name = "Question.findByIsdeleted", query = "SELECT q FROM Question q WHERE q.isdeleted = :isdeleted")
    , @NamedQuery(name = "Question.findByNotifi", query = "SELECT q FROM Question q WHERE q.notifi = :notifi")
    , @NamedQuery(name = "Question.findByQuestionDate", query = "SELECT q FROM Question q WHERE q.questionDate = :questionDate")
    , @NamedQuery(name = "Question.findByClosed", query = "SELECT q FROM Question q WHERE q.closed = :closed")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_id")
    private Integer questionId;
    @Size(max = 145)
    @Column(name = "title")
    @Field
    private String title;
    @Size(max = 4045)
    @Column(name = "body")
    @Field
    private String body;
    @Size(max = 445)
    @Column(name = "image")
    private String image;
    @Size(max = 445)
    @Column(name = "audio")
    private String audio;
    @Size(max = 445)
    @Column(name = "video")
    private String video;
    @Column(name = "rate")
    private Integer rate;
    @Column(name = "verified")
    private Integer verified;
    @NotNull
    @Column(name = "isdeleted")
    private Integer isdeleted;
    @Column(name = "notifi")
    private Integer notifi;
    @Column(name = "question_date")
    @Temporal(TemporalType.DATE)
    private Date questionDate;
    @Column(name = "closed")
    private Integer closed;
    @JoinTable(name = "belongs_to", joinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")}, inverseJoinColumns = {
        @JoinColumn(name = "sub_cat_id", referencedColumnName = "sub_cat_id")})
    @ManyToMany
    private Collection<SubCat> subCatCollection;
    @ManyToMany(mappedBy = "questionCollection")
    private Collection<Person> personRateCollection;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personId;
    @OneToMany(mappedBy = "questionId")
    private Collection<Answers> answersCollection;

    public Question() {
    }

    public Question(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Integer getNotifi() {
        return notifi;
    }

    public void setNotifi(Integer notifi) {
        this.notifi = notifi;
    }

    public Date getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(Date questionDate) {
        this.questionDate = questionDate;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }


    public Collection<SubCat> getSubCatCollection() {
        return subCatCollection;
    }

    public void setSubCatCollection(Collection<SubCat> subCatCollection) {
        this.subCatCollection = subCatCollection;
    }

    public Collection<Person> getPersonRateCollection() {
        return personRateCollection;
    }

    public void setPersonRateCollection(Collection<Person> personRateCollection) {
        this.personRateCollection = personRateCollection;
    }



    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }


    public Collection<Answers> getAnswersCollection() {
        return answersCollection;
    }

    public void setAnswersCollection(Collection<Answers> answersCollection) {
        this.answersCollection = answersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionId != null ? questionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.questionId == null && other.questionId != null) || (this.questionId != null && !this.questionId.equals(other.questionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.t3ala2ma2olk.webservice.dal.entity.Question[ questionId=" + questionId + " ]";
    }
    
}
