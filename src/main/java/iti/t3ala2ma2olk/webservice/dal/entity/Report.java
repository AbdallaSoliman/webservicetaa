/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.entity;

import iti.t3ala2ma2olk.webservice.security.model.Person;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abdalla
 */
@Entity
@Table(name = "report")

@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r")
    , @NamedQuery(name = "Report.findByReportId", query = "SELECT r FROM Report r WHERE r.reportId = :reportId")
    , @NamedQuery(name = "Report.findByMsg", query = "SELECT r FROM Report r WHERE r.msg = :msg")
    , @NamedQuery(name = "Report.findByType", query = "SELECT r FROM Report r WHERE r.type = :type")
    , @NamedQuery(name = "Report.findByReportDate", query = "SELECT r FROM Report r WHERE r.reportDate = :reportDate")
    , @NamedQuery(name = "Report.findByChecked", query = "SELECT r FROM Report r WHERE r.checked = :checked")
    , @NamedQuery(name = "Report.findByAction", query = "SELECT r FROM Report r WHERE r.action = :action")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "report_id")
    private Integer reportId;
    @Size(max = 2045)
    @Column(name = "msg")
    private String msg;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Column(name = "report_date")
    @Temporal(TemporalType.DATE)
    private Date reportDate;
    @Column(name = "checked")
    private Integer checked;
    @Column(name = "action")
    private Integer action;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personId;

    public Report() {
    }

    public Report(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
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
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.t3ala2ma2olk.webservice.dal.entity.Report[ reportId=" + reportId + " ]";
    }
    
}
