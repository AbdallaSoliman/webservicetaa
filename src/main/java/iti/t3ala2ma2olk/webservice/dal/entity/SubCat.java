/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abdalla
 */
@Entity
@Table(name = "sub_cat")

@NamedQueries({
    @NamedQuery(name = "SubCat.findAll", query = "SELECT s FROM SubCat s")
    , @NamedQuery(name = "SubCat.findBySubCatId", query = "SELECT s FROM SubCat s WHERE s.subCatId = :subCatId")
    , @NamedQuery(name = "SubCat.findBySubCatName", query = "SELECT s FROM SubCat s WHERE s.subCatName = :subCatName")
    , @NamedQuery(name = "SubCat.findByDescription", query = "SELECT s FROM SubCat s WHERE s.description = :description")})
public class SubCat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sub_cat_id")
    private Integer subCatId;
    @Size(max = 45)
    @Column(name = "sub_cat_name")
    private String subCatName;
    @Size(max = 445)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "subCatCollection")
    private Collection<Question> questionCollection;
    @JoinColumn(name = "main_categories_id", referencedColumnName = "main_categories_id")
    @ManyToOne
    private MainCategories mainCategoriesId;

    public SubCat() {
    }

    public SubCat(Integer subCatId) {
        this.subCatId = subCatId;
    }

    public Integer getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(Integer subCatId) {
        this.subCatId = subCatId;
    }

    public String getSubCatName() {
        return subCatName;
    }

    public void setSubCatName(String subCatName) {
        this.subCatName = subCatName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 @JsonIgnore
    @XmlTransient
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }
 @JsonIgnore
    public MainCategories getMainCategoriesId() {
        return mainCategoriesId;
    }

    public void setMainCategoriesId(MainCategories mainCategoriesId) {
        this.mainCategoriesId = mainCategoriesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subCatId != null ? subCatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCat)) {
            return false;
        }
        SubCat other = (SubCat) object;
        if ((this.subCatId == null && other.subCatId != null) || (this.subCatId != null && !this.subCatId.equals(other.subCatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.t3ala2ma2olk.webservice.dal.entity.SubCat[ subCatId=" + subCatId + " ]";
    }
    
}
