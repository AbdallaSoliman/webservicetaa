/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.msg;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */
@Setter
@Getter
public class MessageDTO {
 final private String result;

    public MessageDTO(String result) {
        this.result = result;
    }
  
}
