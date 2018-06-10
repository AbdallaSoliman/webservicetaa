/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.pushnotification;

import iti.t3ala2ma2olk.webservice.dto.QuestionDTO;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author abdalla
 */
public class QuestionNotifications  extends NotificationParent<QuestionDTO>{


    	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;
        private static QuestionNotifications instance;
    private QuestionNotifications() {
    }
                public static QuestionNotifications getInstanceUsingDoubleLocking(){
    if(instance == null){
        synchronized (QuestionNotifications.class) {
            if(instance == null){
                instance = new QuestionNotifications();
            }
        }
    }
    return instance;
}
        

    
    public ResponseEntity<?> addNewNotification(QuestionDTO questionDTO){
        JSONObject body = new JSONObject();
		body.put("to", "/topics/" +"QuestionNotifications"+ questionDTO.getQuestionId());
		body.put("priority", "high");
 
		JSONObject notification = new JSONObject();
		notification.put("title", questionDTO.getTitle());
		notification.put("body", questionDTO.getBody());
		
		JSONObject data = new JSONObject();
		data.put("getPersonId", questionDTO.getPersonId().getPersonId());
//		data.put("Key-2", "JSA Data 2");
 
		body.put("notification", notification);
		body.put("data", data);
 
/**
		{
		   "notification": {
		      "title": "JSA Notification",
		      "body": "Happy Message!"
		   },
		   "data": {
		      "Key-1": "JSA Data 1",
		      "Key-2": "JSA Data 2"
		   },
		   "to": "/topics/JavaSampleApproach",
		   "priority": "high"
		}
*/
 
		HttpEntity<String> request = new HttpEntity<>(body.toString());
 
		CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
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