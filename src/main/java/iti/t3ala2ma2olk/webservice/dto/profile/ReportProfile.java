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
public class ReportProfile {
    Integer id;
    String Title;

    public ReportProfile() {
    }

    public ReportProfile(Integer id, String Title) {
        this.id = id;
        this.Title = Title;
    }

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
    
}