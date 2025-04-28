package com.slidra.slidraV1.part.service;

import com.slidra.slidraV1.part.dto.LocationRequest;
import com.slidra.slidraV1.part.dto.LocationResponse;

import java.util.List;

public interface LocationService {
    List<LocationResponse> getAllLocations();

    LocationResponse addNewLocation(LocationRequest locationRequest);
}
