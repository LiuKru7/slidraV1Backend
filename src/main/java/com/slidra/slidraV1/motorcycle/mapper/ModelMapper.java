package com.slidra.slidraV1.motorcycle.mapper;


import com.slidra.slidraV1.motorcycle.dto.ModelRequest;
import com.slidra.slidraV1.motorcycle.dto.ModelResponse;
import com.slidra.slidraV1.motorcycle.model.Model;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ModelMapper {


    ModelResponse toModelResponse(Model model);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "brand", ignore = true)
    Model toModel(ModelRequest modelRequest);
}