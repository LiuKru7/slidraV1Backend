package com.slidra.slidraV1.part.service.impl;

import com.slidra.slidraV1.part.dto.LocationRequest;
import com.slidra.slidraV1.part.dto.LocationResponse;
import com.slidra.slidraV1.part.mapper.LocationMapper;
import com.slidra.slidraV1.part.repository.LocationRepository;
import com.slidra.slidraV1.part.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    public List<LocationResponse> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(locationMapper::toLocationResponse)
                .toList();
    }

    @Override
    public LocationResponse addNewLocation(LocationRequest locationRequest) {
        var location = locationRepository.save(locationMapper.toLocation(locationRequest));
        return locationMapper.toLocationResponse(location);
    }
}
