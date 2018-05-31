/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.special;

import iti.t3ala2ma2olk.webservice.dal.entity.Report;
import iti.t3ala2ma2olk.webservice.dal.entity.SubCat;
import iti.t3ala2ma2olk.webservice.dal.repository.special.CategoriesRepository;
import iti.t3ala2ma2olk.webservice.dto.special.CategoriesDTO;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalla
 */
@Service
public class CategoriesService {

        private static final ModelMapper modelMapper = new ModelMapper();
        
    @Autowired
    private CategoriesRepository categoriesRepository;
    
    public List<CategoriesDTO> getAllMainCategories(Pageable pageable , Integer id) {
        Page page = categoriesRepository.findAll(id,pageable);
        List<SubCat> subCategoriesList = page.getContent();
        List<CategoriesDTO> categoriesList = new ArrayList<>();
        System.out.println("test 5_30"+subCategoriesList.get(0).getSubCatName());
        subCategoriesList.stream()
                .forEach(categories -> categoriesList.add(modelMapper.map(categories, CategoriesDTO.class)));
        System.out.println("test 5_30+1");


        return categoriesList;
 
    }
    //.filter(predicate->predicate.getMainCategoriesId().getMainCategoriesId().equals(id))
}
