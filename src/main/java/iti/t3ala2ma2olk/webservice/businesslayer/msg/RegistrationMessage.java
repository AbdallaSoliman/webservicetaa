/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.msg;

import iti.t3ala2ma2olk.webservice.businesslayer.factory.MessageFactory;
import javax.persistence.Entity;

/**
 *
 * @author abdalla
 */

public class RegistrationMessage {
    
   public static MessageDTO success =MessageFactory.getMessageDTO( "Registration Done successfully");
   public static MessageDTO fail=MessageFactory.getMessageDTO("Registration fail");
       public static MessageDTO repeatedUsername =MessageFactory.getMessageDTO( "Registration fail , repeated Username");
    public static MessageDTO repeatedEmail =MessageFactory.getMessageDTO( "Registration fail , repeated Email");
    public static MessageDTO idNotFound =MessageFactory.getMessageDTO( "Registration fail ,this user does not exist");
    public static MessageDTO uniqueField =MessageFactory.getMessageDTO( "Registration fail ,please chose unique value");
    
}
