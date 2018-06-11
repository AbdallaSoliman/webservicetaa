/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto.special;

import iti.t3ala2ma2olk.webservice.dal.entity.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */

@Getter
@Setter
public class MainCategoriesSpecial implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer mainCategoriesId;

    private String catName;

    private Collection<SubCatSpecial> subCatCollection;

    public MainCategoriesSpecial() {
        subCatCollection=new ArrayList<SubCatSpecial>();
        
    }

    public MainCategoriesSpecial(Integer mainCategoriesId) {
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


    public Collection<SubCatSpecial> getSubCatCollection() {
        return subCatCollection;
    }

    public void setSubCatCollection(Collection<SubCatSpecial> subCatCollection) {
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
        if (!(object instanceof MainCategoriesSpecial)) {
            return false;
        }
        MainCategoriesSpecial other = (MainCategoriesSpecial) object;
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
