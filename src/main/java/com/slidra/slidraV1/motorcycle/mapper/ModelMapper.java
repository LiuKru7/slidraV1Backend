package com.slidra.slidraV1.motorcycle.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ModelMapper {
 ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);


}
