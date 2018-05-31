/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.dal.repository.special;

import iti.t3ala2ma2olk.webservice.dal.entity.MainCategories;
import iti.t3ala2ma2olk.webservice.dal.entity.SubCat;
import iti.t3ala2ma2olk.webservice.dto.profile.util.DTO;
import iti.t3ala2ma2olk.webservice.dto.special.CategoriesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abdalla
 */
public interface CategoriesRepository extends  CrudRepository<SubCat, Integer>{
  //  @Query("select subCatId  distinct subCatName  from  iti.t3ala2ma2olk.webservice.dal.entity.subCat u where u.mainCategoriesId = :mainCategoriesId")
 //  @Query(value = "select * from internal_uddi where urn like %?1% or contact like %?1%",
        //   nativeQuery = true)
    @Query("SELECT new iti.t3ala2ma2olk.webservice.dto.special.CategoriesDTO (p.subCatName,p.subCatId ) FROM iti.t3ala2ma2olk.webservice.dal.entity.SubCat p ")
     public Page<SubCat> findAll(@Param("mainCategoriesId")Integer mainCategoriesId ,Pageable pageable);
}
