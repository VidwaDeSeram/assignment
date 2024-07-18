package com.softedgelab.assignment.Config;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@EnableTransactionManagement
@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}