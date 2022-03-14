package com.algaworks.algalog.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    //class de configurção fr Bean q vai ser disponibilizado a toda aplicação
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
