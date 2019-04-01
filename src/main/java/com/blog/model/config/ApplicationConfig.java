package com.blog.model.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public ModelMapper buildModelMapper(){
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper;
  }
}
