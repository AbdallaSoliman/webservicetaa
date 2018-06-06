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
    
   public static MessageDTO success =new MessageDTO( "Registration Done successfully");
   public static MessageDTO fail=new MessageDTO("Registration fail");
       public static MessageDTO repeatedUsername =new MessageDTO( "Registration fail , repeated Username");
    public static MessageDTO repeatedEmail =new MessageDTO( "Registration fail , repeated Email");
    public static MessageDTO idNotFound =new MessageDTO( "Registration fail ,this user does not exist");
    public static MessageDTO uniqueField =new MessageDTO( "Registration fail ,please chose unique value");
    
}
