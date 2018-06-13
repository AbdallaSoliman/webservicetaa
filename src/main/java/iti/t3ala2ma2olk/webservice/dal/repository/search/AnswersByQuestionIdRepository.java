/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.repository.search;

import iti.t3ala2ma2olk.webservice.dal.entity.Answers;
import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abdalla
 */
public interface AnswersByQuestionIdRepository extends  CrudRepository<Answers, Integer>{
    @Query("select c from Answers c where c.questionId = :questionId")
        public List<Answers> findByQuestionId(@Param("questionId")Question questionId);
}
