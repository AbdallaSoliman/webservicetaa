/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto;

import iti.t3ala2ma2olk.webservice.dal.entity.MainCategories;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */
@Getter
@Setter
public class SubCatDTO {

    public SubCatDTO() {
    }

    
    
    private Integer subCatId;

    private String subCatName;

    private String description;

    private Collection<Question> questionCollection;

    private MainCategories mainCategoriesId;
    
    private String imgUrl;
}
