package com.slidra.slidraV1.part.controller;

import com.slidra.slidraV1.part.dto.LocationRequest;
import com.slidra.slidraV1.part.dto.LocationResponse;
import com.slidra.slidraV1.part.model.Location;
import com.slidra.slidraV1.part.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/part/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<LocationResponse>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @PostMapping
    public ResponseEntity<LocationResponse> addNewLocation(@RequestBody LocationRequest locationRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(locationService.addNewLocation(locationRequest));

    }


}
