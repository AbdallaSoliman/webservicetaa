/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto;

import iti.t3ala2ma2olk.webservice.dal.entity.SubCat;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */
@Getter
@Setter
public class MainCategoriesDTO {

    public MainCategoriesDTO() {
    }

    
    
    private Integer mainCategoriesId;

    private String catName;

    private Collection<SubCat> subCatCollection;
}
