/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.factory;

import org.modelmapper.ModelMapper;

/**
 *
 * @author abdalla
 */
public class ModelMapperFactory {

    private static volatile ModelMapper instance;

    public static ModelMapper getModelMapper() {
        ModelMapper modelMapper = ModelMapperFactory.instance;
        if (modelMapper == null) {
            synchronized (ModelMapperFactory.class) {
                modelMapper = ModelMapperFactory.instance;
                if (modelMapper == null) {
                    ModelMapperFactory.instance = modelMapper = new ModelMapper();
                }
            }
        }
        return modelMapper;
    }
}
