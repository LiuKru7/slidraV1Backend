package com.slidra.slidraV1.part.service.impl;

import com.slidra.slidraV1.part.repository.WarehouseRepository;
import com.slidra.slidraV1.part.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;
}
