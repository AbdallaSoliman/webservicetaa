/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto;


import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abdalla
 */
@Getter
@Setter
public class AdminDTO {

    public AdminDTO() {
    }


    private Integer adminId;

    private String username;

    private String password;
}
