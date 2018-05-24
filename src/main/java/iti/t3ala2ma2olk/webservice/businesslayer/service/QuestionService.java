/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service;

import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import iti.t3ala2ma2olk.webservice.dal.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class QuestionService {
        @Autowired
    private QuestionRepository questionRepository;
    
     public List<Question> getAllQuestion(){
            List<Question> myIntList= new ArrayList<>();
            questionRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }
    public  Question getQuestion(Integer id){
            return questionRepository.findById(id).orElse(null);
    }

    public void addQuestion(Question topic) {
        questionRepository.save(topic);
   }

    public void updateQuestion(Question topic) {
             questionRepository.save(topic);
    }

   public void deleteQuestion(Integer id) {
         questionRepository.deleteById(id);
    }
    
}
