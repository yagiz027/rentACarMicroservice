package com.yagiz.commonservice.Configuration.ModelMappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yagiz.commonservice.utils.ModelMapper.ModelMapperManager;
import com.yagiz.commonservice.utils.ModelMapper.ModelMapperService;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }

    @Bean
    public ModelMapperService getModelMapperService(ModelMapper mapper)
    {
        return new ModelMapperManager(mapper);
    }
}
