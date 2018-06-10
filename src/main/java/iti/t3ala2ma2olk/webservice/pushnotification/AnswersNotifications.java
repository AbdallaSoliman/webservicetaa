/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.pushnotification;

import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class AnswersNotifications extends NotificationParent<Answers> {

    @Autowired(required = true)
    AndroidPushNotificationsService androidPushNotificationsService;

//    private static AnswersNotifications instance;
//
//    private AnswersNotifications() {
//    }
//
//    public static AnswersNotifications getInstanceUsingDoubleLocking() {
//        if (instance == null) {
//            synchronized (AnswersNotifications.class) {
//                if (instance == null) {
//                    instance = new AnswersNotifications();                    
//                }
//            }
//        }
//        return instance;
//    }


    @Override
    public ResponseEntity<?> addNewNotification(Answers answers) {
        if (androidPushNotificationsService == null) {
            System.out.println("androidPushNotificationsService  null");
        }
        JSONObject body = new JSONObject();

        body.put("to", "/topics/" + "AnswersNotifications" + answers.getAnswersId());
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", answers.getAnswer());
//		notification.put("body", answers.getBody());

        JSONObject data = new JSONObject();
        data.put("getPersonId", answers.getPersonId().getPersonId());
//		data.put("Key-2", "JSA Data 2");

        body.put("notification", notification);
        body.put("data", data);

        /**
         * {
         * "notification": { "title": "JSA Notification", "body": "Happy
         * Message!" }, "data": { "Key-1": "JSA Data 1", "Key-2": "JSA Data 2"
         * }, "to": "/topics/JavaSampleApproach", "priority": "high" }
         */
        HttpEntity<String> request = new HttpEntity<>(body.toString());
        System.out.println("test notifi");

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        if (pushNotification != null) {
            System.out.println("pushNotification no null");
        }
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();

            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }

}
