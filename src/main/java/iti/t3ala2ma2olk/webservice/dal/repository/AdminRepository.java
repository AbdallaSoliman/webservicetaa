/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.repository;

import iti.t3ala2ma2olk.webservice.dal.entity.Admin;
import iti.t3ala2ma2olk.webservice.dto.AdminDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abdalla
 */
public interface AdminRepository extends  CrudRepository<Admin, Integer>{

    public Admin findByUsernameAndPassword(String username, String password);

    public Admin findByUsername(String username);

    Page<Admin> findAll(Pageable pageable);

    public Object findByUsername(String username, String encode);

}
