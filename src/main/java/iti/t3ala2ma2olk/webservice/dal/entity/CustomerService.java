/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abdalla
 */
@Entity
@Table(name = "customer_service")

@NamedQueries({
    @NamedQuery(name = "CustomerService.findAll", query = "SELECT c FROM CustomerService c")
    , @NamedQuery(name = "CustomerService.findByService", query = "SELECT c FROM CustomerService c WHERE c.service = :service")
    , @NamedQuery(name = "CustomerService.findByJoinDate", query = "SELECT c FROM CustomerService c WHERE c.joinDate = :joinDate")
    , @NamedQuery(name = "CustomerService.findByExpDate", query = "SELECT c FROM CustomerService c WHERE c.expDate = :expDate")
    , @NamedQuery(name = "CustomerService.findByPersonId", query = "SELECT c FROM CustomerService c WHERE c.personId = :personId")})
public class CustomerService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "service")
    private String service;
    @Column(name = "join_date")
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Column(name = "exp_date")
    @Temporal(TemporalType.DATE)
    private Date expDate;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "person_id")
    private Integer personId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public CustomerService() {
    }

    public CustomerService(Integer personId) {
        this.personId = personId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
 @JsonIgnore
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        if (!(object instanceof CustomerService)) {
            return false;
        }
        CustomerService other = (CustomerService) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.t3ala2ma2olk.webservice.dal.entity.CustomerService[ personId=" + personId + " ]";
    }
    
}
