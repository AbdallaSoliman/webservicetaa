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
@Getter
@Setter
public class DescriptionDTO {
    
    private Integer subCatId;
       
    private String subCatName;

    private String description;
  
    private String imgUrl;
}
