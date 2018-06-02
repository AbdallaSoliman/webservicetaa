/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.controller.special;

import iti.t3ala2ma2olk.webservice.businesslayer.service.MainCategoriesService;
import iti.t3ala2ma2olk.webservice.businesslayer.service.SubCatService;
import iti.t3ala2ma2olk.webservice.businesslayer.service.special.CategoriesService;
import iti.t3ala2ma2olk.webservice.dal.entity.MainCategories;
import iti.t3ala2ma2olk.webservice.dto.SubCatDTO;
import iti.t3ala2ma2olk.webservice.dto.special.CategoriesDTO;
import iti.t3ala2ma2olk.webservice.dto.special.DescriptionDTO;
import iti.t3ala2ma2olk.webservice.dto.special.MainCatDTOSpe;
import iti.t3ala2ma2olk.webservice.dto.special.SubCatDTOSpe;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdalla
 */

@RestController
public class CategoriesController {
        @Autowired
    private CategoriesService categoriesService;
        
            @Autowired
    private MainCategoriesService mainCategoriesService; 
            
                    
    @Autowired
    private SubCatService subCatService;
    
        @RequestMapping("/Categories/{id}")
    public List<CategoriesDTO> getAllMainCategories(@PageableDefault(value=100, page=0) Pageable pageable,@PathVariable Integer id) {
        return categoriesService.getAllMainCategories(pageable,id);
    }
    @RequestMapping("/CategoriesByName/{SubCatName}")
      public List<DescriptionDTO> getAllDescriptionDTOBySubCatName(@PageableDefault(value=10, page=0) Pageable pageable,@PathVariable String SubCatName) {
             return categoriesService.getAllDescriptionDTOBySubCatName(pageable,  SubCatName);
      }
      
      @RequestMapping(method = RequestMethod.DELETE,value ="/CategoriesByName/{SubCatName}")
      public ResponseEntity<?> deleteAllDescriptionDTOBySubCatName(@PathVariable String SubCatName) {
             return categoriesService.deleteAllDescriptionDTOBySubCatName(SubCatName);
      } 
      
      
      /* ali */
@RequestMapping("/MainCategoryWithSubs")
    public List<MainCatDTOSpe> getAllMainCategoriesAndQuestions(@PageableDefault(value=10, page=0) Pageable pageable) {
        List<MainCategories> catList=mainCategoriesService.getAllMainCategories(pageable);
       
         List<MainCatDTOSpe> catDTOList=new ArrayList<MainCatDTOSpe>();
         for (int i=0;i<catList.size();++i){
             if(catList.get(i).getCatName().equals("Main")){
                 final int loop=i;
                 catList.get(i).getSubCatCollection().forEach((temp1) -> {

                     if(!temp1.getSubCatName().equals("notValue")){
                         MainCatDTOSpe mainTemp=new MainCatDTOSpe();
                         mainTemp.setCatName(temp1.getSubCatName());
                         mainTemp.setImgUrl(temp1.getImgUrl());
                         List <SubCatDTOSpe> tempSubs=new ArrayList <SubCatDTOSpe>();
                         SubCatDTOSpe subTemp=new SubCatDTOSpe();
                         subTemp.setCatId(temp1.getSubCatId());
                         subTemp.setCatName(temp1.getDescription());
                         subTemp.setNumberOfQues(getNumberOfQuestion(temp1.getSubCatId()));
                         tempSubs.add(subTemp);
                         
                         catList.get(loop).getSubCatCollection().forEach((temp2) -> {
                             if(temp1.getSubCatName().equals(temp2.getSubCatName()) && temp1 != temp2 ){
                                SubCatDTOSpe subTemp2=new SubCatDTOSpe();
                                subTemp2.setCatId(temp2.getSubCatId());
                                subTemp2.setCatName(temp2.getDescription());
                                subTemp2.setNumberOfQues(getNumberOfQuestion(temp2.getSubCatId()));
                                tempSubs.add(subTemp2);
                                 
                                temp2.setSubCatName("notValue");
                             }
                         
                         });
                         temp1.setSubCatName("notValue");
                         mainTemp.setSubs(tempSubs);

                         mainTemp.getSubs().forEach((subTempCount) -> {
                             mainTemp.setNumberOfQues(mainTemp.getNumberOfQues()+subTempCount.getNumberOfQues());
                         });
                         catDTOList.add(mainTemp);
                     }
                });
             }
         }
         
         
        return catDTOList;
    }     
    
    public int getNumberOfQuestion(int catID){
         SubCatDTO  subCat=subCatService.getSubCatWithId(catID);
         return subCat.getQuestionCollection().size();
    }
/* ali */
}
