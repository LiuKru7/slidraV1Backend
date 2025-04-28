package com.slidra.slidraV1.part.mapper;

import com.slidra.slidraV1.part.dto.LocationRequest;
import com.slidra.slidraV1.part.dto.LocationResponse;
import com.slidra.slidraV1.part.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationResponse toLocationResponse(Location location);

    @Mapping(target = "id", ignore = true)
    Location toLocation(LocationRequest locationRequest);
}
