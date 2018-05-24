/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abdalla
 */
@Entity
@Table(name = "main_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MainCategories.findAll", query = "SELECT m FROM MainCategories m")
    , @NamedQuery(name = "MainCategories.findByMainCategoriesId", query = "SELECT m FROM MainCategories m WHERE m.mainCategoriesId = :mainCategoriesId")
    , @NamedQuery(name = "MainCategories.findByCatName", query = "SELECT m FROM MainCategories m WHERE m.catName = :catName")})
public class MainCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "main_categories_id")
    private Integer mainCategoriesId;
    @Size(max = 45)
    @Column(name = "cat_name")
    private String catName;
    @OneToMany(mappedBy = "mainCategoriesId")
    private Collection<SubCat> subCatCollection;

    public MainCategories() {
    }

    public MainCategories(Integer mainCategoriesId) {
        this.mainCategoriesId = mainCategoriesId;
    }

    public Integer getMainCategoriesId() {
        return mainCategoriesId;
    }

    public void setMainCategoriesId(Integer mainCategoriesId) {
        this.mainCategoriesId = mainCategoriesId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @XmlTransient
    public Collection<SubCat> getSubCatCollection() {
        return subCatCollection;
    }

    public void setSubCatCollection(Collection<SubCat> subCatCollection) {
        this.subCatCollection = subCatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mainCategoriesId != null ? mainCategoriesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MainCategories)) {
            return false;
        }
        MainCategories other = (MainCategories) object;
        if ((this.mainCategoriesId == null && other.mainCategoriesId != null) || (this.mainCategoriesId != null && !this.mainCategoriesId.equals(other.mainCategoriesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.t3ala2ma2olk.webservice.dal.entity.MainCategories[ mainCategoriesId=" + mainCategoriesId + " ]";
    }
    
}
