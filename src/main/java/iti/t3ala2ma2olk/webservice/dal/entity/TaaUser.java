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
@Table(name = "taa_user")

@NamedQueries({
    @NamedQuery(name = "TaaUser.findAll", query = "SELECT t FROM TaaUser t")
    , @NamedQuery(name = "TaaUser.findByPhone", query = "SELECT t FROM TaaUser t WHERE t.phone = :phone")
    , @NamedQuery(name = "TaaUser.findByCity", query = "SELECT t FROM TaaUser t WHERE t.city = :city")
    , @NamedQuery(name = "TaaUser.findByDistrict", query = "SELECT t FROM TaaUser t WHERE t.district = :district")
    , @NamedQuery(name = "TaaUser.findByCountry", query = "SELECT t FROM TaaUser t WHERE t.country = :country")
    , @NamedQuery(name = "TaaUser.findByRate", query = "SELECT t FROM TaaUser t WHERE t.rate = :rate")
    , @NamedQuery(name = "TaaUser.findByBirthofdate", query = "SELECT t FROM TaaUser t WHERE t.birthofdate = :birthofdate")
    , @NamedQuery(name = "TaaUser.findByPersonId", query = "SELECT t FROM TaaUser t WHERE t.personId = :personId")})
public class TaaUser implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "phone")
    private String phone;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "district")
    private String district;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Column(name = "rate")
    private Integer rate;
    @Column(name = "birthofdate")
    @Temporal(TemporalType.DATE)
    private Date birthofdate;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "person_id")
    private Integer personId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public TaaUser() {
    }

    public TaaUser(Integer personId) {
        this.personId = personId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Date getBirthofdate() {
        return birthofdate;
    }

    public void setBirthofdate(Date birthofdate) {
        this.birthofdate = birthofdate;
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
        if (!(object instanceof TaaUser)) {
            return false;
        }
        TaaUser other = (TaaUser) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.t3ala2ma2olk.webservice.dal.entity.TaaUser[ personId=" + personId + " ]";
    }
    
}
