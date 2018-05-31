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
    /* work without  DISTINCT*/
    @Query("FROM iti.t3ala2ma2olk.webservice.dal.entity.SubCat p "
            + "where p.mainCategoriesId = :mainCategoriesId")
    public Page<Object> findDistinctBySubCatNameAndMainCategoriesId(@Param("mainCategoriesId")MainCategories mainCategoriesId ,Pageable pageable);


}
