/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.service.special;

import iti.t3ala2ma2olk.webservice.dal.entity.Report;
import iti.t3ala2ma2olk.webservice.dal.entity.SubCat;
import iti.t3ala2ma2olk.webservice.dal.repository.MainCategoriesRepository;
import iti.t3ala2ma2olk.webservice.dal.repository.special.CategoriesRepository;
import iti.t3ala2ma2olk.webservice.dto.special.CategoriesDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
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
    
    @Autowired
    private MainCategoriesRepository mainCategoriesRepository;
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
}
    public List<CategoriesDTO> getAllMainCategories(Pageable pageable , Integer id) {
    
        Page page = categoriesRepository.findDistinctBySubCatNameAndMainCategoriesId(
                mainCategoriesRepository.findById(id).orElse(null),pageable);
        List<SubCat> subCategoriesList = page.getContent();
        List<CategoriesDTO> categoriesList = new ArrayList<>();
        subCategoriesList.stream().filter(distinctByKey(SubCat::getSubCatName))
                .forEach(categories -> categoriesList.add(modelMapper.map(categories, CategoriesDTO.class)));


        return categoriesList;
 
    }
    //.filter(predicate->predicate.getMainCategoriesId().getMainCategoriesId().equals(id))
}
