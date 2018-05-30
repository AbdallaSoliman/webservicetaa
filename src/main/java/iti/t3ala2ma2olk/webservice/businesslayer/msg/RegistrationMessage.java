/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.msg;

import javax.persistence.Entity;

/**
 *
 * @author abdalla
 */

public class RegistrationMessage {
    
   public static String success="Registration Done successfully";
   public static String fail="Registration fail";
       public static String repeatedUsername = "Registration fail , repeated Username";
    public static String repeatedEmail = "Registration fail , repeated Email";
    public static String idNotFound = "Registration fail ,this user does not exist";
    public static String uniqueField = "Registration fail ,please chose unique value";
    
}
