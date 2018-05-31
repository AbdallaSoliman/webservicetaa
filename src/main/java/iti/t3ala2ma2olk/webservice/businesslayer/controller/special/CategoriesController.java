/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.special;

import iti.t3ala2ma2olk.webservice.businesslayer.service.special.CategoriesService;
import iti.t3ala2ma2olk.webservice.dto.special.CategoriesDTO;
import iti.t3ala2ma2olk.webservice.dto.special.DescriptionDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdalla
 */

@RestController
public class CategoriesController {
        @Autowired
    private CategoriesService categoriesService;
    
        @RequestMapping("/Categories/{id}")
    public List<CategoriesDTO> getAllMainCategories(@PageableDefault(value=10, page=0) Pageable pageable,@PathVariable Integer id) {
        return categoriesService.getAllMainCategories(pageable,id);
    }
    @RequestMapping("/CategoriesByName/{SubCatName}")
      public List<DescriptionDTO> getAllDescriptionDTOBySubCatName(@PageableDefault(value=10, page=0) Pageable pageable,@PathVariable String SubCatName) {
             return categoriesService.getAllDescriptionDTOBySubCatName(pageable,  SubCatName);
      }
}
