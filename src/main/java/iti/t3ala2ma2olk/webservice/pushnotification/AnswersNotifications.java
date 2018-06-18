/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.pushnotification;

import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
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
        if (answers.getQuestionId() != null) {
            body.put("to", "/topics/" + "QuestionNotifications" + answers.getQuestionId().getQuestionId());
        }
        body.put("priority", "high");

        JSONObject notification = new JSONObject();

        if (answers.getPersonId().getUsername() != null) {
            notification.put("title", answers.getPersonId().getUsername());
        }

        if (answers.getAnswer() != null) {
            notification.put("body", answers.getAnswer());
        }

//		notification.put("body", answers.getBody());
        JSONObject mData = new JSONObject();

        if (answers.getPersonId().getImage() != null) {
            mData.put("image", answers.getPersonId().getImage());
        }
        if (answers.getPersonId().getPersonId() != null) {
            mData.put("getPersonId", answers.getPersonId().getPersonId());
        }
        if (answers.getPersonId().getFirst() != null) {
            mData.put("title", answers.getPersonId().getFirst());
        }
        mData.put("is_background", false);
        Date utilDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        mData.put("timestamp", new Timestamp(utilDate.getTime()));
        if (answers.getPersonId().getFirst() != null) {
            mData.put("is_background", answers.getPersonId().getFirst());
        }

        if (answers.getPersonId().getUsername() != null) {
            mData.put("title", answers.getPersonId().getUsername());
        }

        if (answers.getAnswer() != null) {
            mData.put("message", answers.getAnswer());
        }
//		data.put("Key-2", "JSA Data 2");

        body.put("notification", notification);
        body.put("data", mData);

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
