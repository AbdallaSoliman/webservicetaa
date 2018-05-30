/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.repository;

import iti.t3ala2ma2olk.webservice.dal.entity.TaaUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author abdalla
 */
public interface TaaUserRepository extends  CrudRepository<TaaUser, Integer>{
        public Page<TaaUser> findAll(Pageable pageable);
}
