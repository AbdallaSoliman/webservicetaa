/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.factory;

import iti.t3ala2ma2olk.webservice.businesslayer.msg.MessageDTO;

/**
 *
 * @author abdalla
 */
public class MessageFactory {

    private static volatile MessageDTO instance;

    public static MessageDTO getMessageDTO(String result) {

        MessageFactory.instance = new MessageDTO(result);

        return instance;
    }
}
