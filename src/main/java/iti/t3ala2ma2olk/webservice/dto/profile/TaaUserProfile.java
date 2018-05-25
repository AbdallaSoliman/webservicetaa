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
    String name;

    public TaaUserProfile() {
    }

    
    
    public TaaUserProfile(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
