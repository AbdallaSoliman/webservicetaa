/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.NotifiAnswers;
import iti.t3ala2ma2olk.webservice.dal.repository.NotifiAnswersRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class NotifiAnswersService {
        @Autowired
    private NotifiAnswersRepository notifiAnswersRepository;
    
     public List<NotifiAnswers> getAllNotifiAnswers(){
            List<NotifiAnswers> myIntList= new ArrayList<>();
            notifiAnswersRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }
    public  NotifiAnswers getNotifiAnswers(Integer id){
            return notifiAnswersRepository.findById(id).orElse(null);
    }

    public void addNotifiAnswers(NotifiAnswers topic) {
        notifiAnswersRepository.save(topic);
   }

    public void updateNotifiAnswers(NotifiAnswers topic) {
             notifiAnswersRepository.save(topic);
    }

   public void deleteNotifiAnswers(Integer id) {
         notifiAnswersRepository.deleteById(id);
    }
    
}
