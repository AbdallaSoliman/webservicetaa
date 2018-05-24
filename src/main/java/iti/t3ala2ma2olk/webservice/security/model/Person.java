/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.dal.entity.CustomerService;
import iti.t3ala2ma2olk.webservice.dal.entity.NotifiAnswers;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dal.entity.Report;
import iti.t3ala2ma2olk.webservice.dal.entity.TaaUser;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abdalla
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId")
    , @NamedQuery(name = "Person.findByImage", query = "SELECT p FROM Person p WHERE p.image = :image")
    , @NamedQuery(name = "Person.findByFirst", query = "SELECT p FROM Person p WHERE p.first = :first")
    , @NamedQuery(name = "Person.findByLast", query = "SELECT p FROM Person p WHERE p.last = :last")
    , @NamedQuery(name = "Person.findByPassword", query = "SELECT p FROM Person p WHERE p.password = :password")
    , @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email")
    , @NamedQuery(name = "Person.findByType", query = "SELECT p FROM Person p WHERE p.type = :type")
    , @NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender")
    , @NamedQuery(name = "Person.findByEnabled", query = "SELECT p FROM Person p WHERE p.enabled = :enabled")
    , @NamedQuery(name = "Person.findByUsername", query = "SELECT p FROM Person p WHERE p.username = :username")
    , @NamedQuery(name = "Person.findByLastPasswordResetDate", query = "SELECT p FROM Person p WHERE p.lastPasswordResetDate = :lastPasswordResetDate")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_id")
    private Integer personId;
    @Size(max = 645)
    private String image;
    @Size(max = 45)
    private String first;
    @Size(max = 45)
    private String last;
    @Size(max = 70)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    private String email;
    @Size(max = 45)
    private String type;
    @Size(max = 45)
    private String gender;
    private boolean enabled;
    @Size(max = 50)
    private String username;
    @Column(name = "last_password_reset_date")
    @Temporal(TemporalType.DATE)
    private Date lastPasswordResetDate;
    

    
    
        @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "authority_id")})
    private List<Authority> authorities;

    @JoinTable(name = "rate_answers", joinColumns = {
        @JoinColumn(name = "person_id", referencedColumnName = "person_id")}, inverseJoinColumns = {
        @JoinColumn(name = "answers_id", referencedColumnName = "answers_id")})
    @ManyToMany
    private Collection<Answers> answersCollection;
    @JoinTable(name = "rate_question", joinColumns = {
        @JoinColumn(name = "person_id", referencedColumnName = "person_id")}, inverseJoinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")})    
    @ManyToMany
    private Collection<Question> questionCollection;
    
//    @OneToMany(mappedBy = "personId")
//    private Collection<Question> questionCollection;
    
    @OneToMany(mappedBy = "personId")    
    private Collection<NotifiAnswers> notifiAnswersCollection;
    
//    @OneToMany(mappedBy = "personId")
//    private Collection<Answers> answersCollection;
    
    @OneToMany(mappedBy = "personId")
    private Collection<Report> reportCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private CustomerService customerService;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private TaaUser taaUser;
    public Person() {
    }

    public Person(Integer personId) {
        this.personId = personId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
// @JsonIgnore
//    public Collection<Answers> getAnswersCollection() {
//        return answersCollection;
//    }
//
//    public void setAnswersCollection(Collection<Answers> answersCollection) {
//        this.answersCollection = answersCollection;
//    }
// @JsonIgnore
//    public Collection<Question> getQuestionCollection() {
//        return questionCollection;
//    }
//
//    public void setQuestionCollection(Collection<Question> questionCollection) {
//        this.questionCollection = questionCollection;
//    }
 @JsonIgnore
    public Collection<NotifiAnswers> getNotifiAnswersCollection() {
        return notifiAnswersCollection;
    }

    public void setNotifiAnswersCollection(Collection<NotifiAnswers> notifiAnswersCollection) {
        this.notifiAnswersCollection = notifiAnswersCollection;
    }
 @JsonIgnore
    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public TaaUser getTaaUser() {
        return taaUser;
    }

    public void setTaaUser(TaaUser taaUser) {
        this.taaUser = taaUser;
    }
 @JsonIgnore
    public Collection<Answers> getAnswersCollection() {
        return answersCollection;
    }

    public void setAnswersCollection(Collection<Answers> answersCollection) {
        this.answersCollection = answersCollection;
    }
 @JsonIgnore
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }







    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.t3ala2ma2olk.webservice.security.model.Person[ personId=" + personId + " ]";
    }
    
}
