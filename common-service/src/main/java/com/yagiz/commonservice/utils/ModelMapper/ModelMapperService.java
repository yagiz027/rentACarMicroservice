package com.yagiz.commonservice.utils.ModelMapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
