/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.msg;

/**
 *
 * @author abdalla
 */
public class UpdateMessage {

    public static MessageDTO success =new MessageDTO( "Update Done successfully");
    public static MessageDTO fail = new MessageDTO( "Update fail");
    public static MessageDTO repeatedUsername =new MessageDTO(  "Update fail , repeated Username");
    public static MessageDTO repeatedEmail =new MessageDTO(  "Update fail , repeated Email");
    public static MessageDTO idNotFound =new MessageDTO(  "Update fail ,this user does not exist");
    public static MessageDTO uniqueField =new MessageDTO(  "Update fail ,please chose unique value");
}
