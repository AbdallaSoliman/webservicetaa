/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.repository;


import iti.t3ala2ma2olk.webservice.dal.entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
//@Repository
public interface QuestionRepository extends  CrudRepository<Question, Integer>{
    
}
