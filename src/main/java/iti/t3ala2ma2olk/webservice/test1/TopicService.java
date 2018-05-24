/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.test1;


import iti.t3ala2ma2olk.webservice.dal.repository.QuestionRepository;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class TopicService {
   
   @Autowired
    private QuestionRepository questionRepository;
    
    private List<Question> myList= new ArrayList<>( Arrays.asList(
        new Question(),
          new Question(),
          new Question(),
          new Question()
        ));
        public List<Question> getAllTopic(){
            List<Question> myIntList= new ArrayList<>();
            questionRepository.findAll().forEach(myIntList::add);
        return myIntList;
    }
    public  Question getTopic(String id){
      //  return myList.stream().filter(t-> t.getTitle().equals(id)).findFirst().get();
      return questionRepository.findById(Integer.SIZE).orElse(null);
    }

    public void addTopic(Question topic) {
        questionRepository.save(topic);
   }

    public void updateTopic(String id, Question topic) {
            questionRepository.save(topic);
    }

   public void deleteTopic(String id) {
        questionRepository.deleteById(Integer.SIZE);
    }
        
}
