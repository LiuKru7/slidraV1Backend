package com.slidra.slidraV1.motorcycle.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {
 ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);


}
