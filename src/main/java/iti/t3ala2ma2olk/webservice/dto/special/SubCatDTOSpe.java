/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto.special;

import iti.t3ala2ma2olk.webservice.dal.entity.MainCategories;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ali Alzantot
 */

@Getter
@Setter

public class SubCatDTOSpe {
       
    private Integer CatId;

    private String CatName;

    private String imgUrl;
    
    private int numberOfQues;
    
    
}
