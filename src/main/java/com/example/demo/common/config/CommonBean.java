package com.example.demo.common.config;

import org.modelmapper.Conditions;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class CommonBean {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setPropertyCondition(Conditions.isNotNull())   // null일경우 복사하지 않도록 설정
                .setFieldMatchingEnabled(true)  // setter없이 맵핑 되도록 설정
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)  // setter없이 맵핑 되도록 설정
                .setMatchingStrategy(MatchingStrategies.STRICT);    // 필드명이 같을때만 맵핑하도록 설정
        return modelMapper;
    }
    
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {

    	CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        characterEncodingFilter.setEncoding("UTF-8");

        characterEncodingFilter.setForceEncoding(true);

        return characterEncodingFilter;

    }
    
}
