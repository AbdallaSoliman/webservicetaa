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
public class FindMessage {
    public static MessageDTO success =MessageFactory.getMessageDTO( "Find Done successfully");
    public static MessageDTO fail =MessageFactory.getMessageDTO(  "Find fail");
}
