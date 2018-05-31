/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto.special;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */
@Setter
@Getter
public class CategoriesDTO {

    private Integer subCatId;
    private String subCatName;

    public CategoriesDTO() {
    }

    public CategoriesDTO( String subCatName ,Integer subCatId) {
        this.subCatId = subCatId;
        this.subCatName = subCatName;
    }
    
}
