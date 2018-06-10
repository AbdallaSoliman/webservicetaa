/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.special;

import iti.t3ala2ma2olk.webservice.businesslayer.service.SubCatService;
import iti.t3ala2ma2olk.webservice.dto.SubCatDTO;
import iti.t3ala2ma2olk.webservice.dto.special.QuestionCustomDTO;
import iti.t3ala2ma2olk.webservice.dto.special.QuestionWithSubCatDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ali Alzantot
 */

@RestController
public class QuestionsController {
    
    
    @Autowired
    private SubCatService subCatService;
    
    @RequestMapping("/QuestionWithSubCat/{id}")
    public QuestionWithSubCatDTO  questionWithsubCat(@PathVariable Integer id) {
        QuestionWithSubCatDTO questionWithSubCatDTO=new QuestionWithSubCatDTO();
         List <QuestionCustomDTO> questions=new ArrayList<QuestionCustomDTO>();
         SubCatDTO  subCat=subCatService.getSubCatWithId(id);
         
         
         subCat.getQuestionCollection().forEach((temp) -> {
             if(temp.getIsdeleted()!= 1){
                QuestionCustomDTO tempQuestionCustomDTO=new QuestionCustomDTO();
                tempQuestionCustomDTO.setQuestionId(temp.getQuestionId());
                tempQuestionCustomDTO.setTitle(temp.getTitle());
                tempQuestionCustomDTO.setQuestionDate(temp.getQuestionDate());
                tempQuestionCustomDTO.setVerified(temp.getVerified());
                tempQuestionCustomDTO.setNumOfAns(temp.getAnswersCollection().size());
                questions.add(tempQuestionCustomDTO);
             }
         });
         
         questionWithSubCatDTO.setQuestions(questions);
         
         return questionWithSubCatDTO;
    }
    
    
}
