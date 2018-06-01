/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto.special;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ali Alzantot
 */

@Getter
@Setter
public class QuestionCustomDTO {
    private Integer questionId;
    private String title;
    private Integer numOfAns;
    private Integer verified;
    private Date questionDate;
    
}