/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.factory;

import iti.t3ala2ma2olk.webservice.businesslayer.msg.MessageDTO;
import iti.t3ala2ma2olk.webservice.businesslayer.msg.QuestionIdDTO;

/**
 *
 * @author abdalla
 */
public class MessageFactory {

    private static volatile MessageDTO instanceMessageDTO;
    private static volatile QuestionIdDTO instanceQuestionIdDTO;

    public static MessageDTO getMessageDTO(String result) {

        MessageFactory.instanceMessageDTO = new MessageDTO(result);

        return instanceMessageDTO;
    }
        public static QuestionIdDTO getQuestionIdDTO(int result) {

        MessageFactory.instanceQuestionIdDTO = new QuestionIdDTO(result);

        return instanceQuestionIdDTO;
    }
}
