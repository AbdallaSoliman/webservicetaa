/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dto.profile;

/**
 *
 * @author abdalla
 */
public class TaaUserProfile {
    Integer id;
    String username;

    public TaaUserProfile() {
    }

    
    
 
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TaaUserProfile(Integer id, String username) {
        this.id = id;
        this.username = username;
    }


    
}
