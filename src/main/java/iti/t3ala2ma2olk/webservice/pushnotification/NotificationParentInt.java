/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.pushnotification;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author abdalla
 */
public interface NotificationParentInt {
    public abstract <T> ResponseEntity<?> addNewNotification(T beanDTO);
}
