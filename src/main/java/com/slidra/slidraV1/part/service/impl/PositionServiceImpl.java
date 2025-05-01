package com.slidra.slidraV1.part.service.impl;

import com.slidra.slidraV1.part.repository.PositionRepository;
import com.slidra.slidraV1.part.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
}
