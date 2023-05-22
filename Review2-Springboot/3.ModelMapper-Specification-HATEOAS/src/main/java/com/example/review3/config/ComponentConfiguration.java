package com.example.review3.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:43 PM
 * Description: ...
 */
@Configuration
public class ComponentConfiguration {
    @Bean
    public ModelMapper initModelMapper(){
        return new ModelMapper();
    }

}
