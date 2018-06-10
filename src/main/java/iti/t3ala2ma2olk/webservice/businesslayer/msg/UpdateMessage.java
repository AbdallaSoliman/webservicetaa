/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.msg;

import iti.t3ala2ma2olk.webservice.businesslayer.factory.MessageFactory;

/**
 *
 * @author abdalla
 */
public class UpdateMessage {

    public static MessageDTO success =MessageFactory.getMessageDTO("Update Done successfully");
    public static MessageDTO fail =MessageFactory.getMessageDTO( "Update fail");
    public static MessageDTO repeatedUsername =MessageFactory.getMessageDTO(  "Update fail , repeated Username");
    public static MessageDTO repeatedEmail =MessageFactory.getMessageDTO(  "Update fail , repeated Email");
    public static MessageDTO idNotFound =MessageFactory.getMessageDTO(  "Update fail ,this user does not exist");
    public static MessageDTO uniqueField =MessageFactory.getMessageDTO(  "Update fail ,please chose unique value");
}
