/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.dal.repository.AnswersRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class AnswersService {
      @Autowired
    private AnswersRepository answersRepository;
    
     public List<Answers> getAllAnswers(){
            List<Answers> myIntList= new ArrayList<>();
            answersRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }
    public  Answers getAnswers(Integer id){
            return answersRepository.findById(id).orElse(null);
    }

    public void addAnswers(Answers topic) {
        answersRepository.save(topic);
   }

    public void updateAnswers(Answers topic) {
             answersRepository.save(topic);
    }

   public void deleteAnswers(Integer id) {
         answersRepository.deleteById(id);
    }
      
}
