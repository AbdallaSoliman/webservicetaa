/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto.profile;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */
@Setter
@Getter
public class CustomerServiceProfile {

   private Integer id;
   private String username;

    public CustomerServiceProfile() {
    }

   
   
    public CustomerServiceProfile(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
   
   
}
