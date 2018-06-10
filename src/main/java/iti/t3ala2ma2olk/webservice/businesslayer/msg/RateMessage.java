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
public class RateMessage {
      public static MessageDTO success =MessageFactory.getMessageDTO( "Rate Done successfully");
   public static MessageDTO fail=MessageFactory.getMessageDTO("Rate fail");
    public static MessageDTO repeated=MessageFactory.getMessageDTO("Rate fail Person make Rate before");
    public static MessageDTO deleteSuccess=MessageFactory.getMessageDTO("Rate remove Done successfully");
    public static MessageDTO deleteFail=MessageFactory.getMessageDTO("Rate remove fail ");
}
