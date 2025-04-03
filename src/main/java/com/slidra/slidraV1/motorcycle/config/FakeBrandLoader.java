package com.slidra.slidraV1.motorcycle.config;

import com.slidra.slidraV1.motorcycle.model.Brand;
import com.slidra.slidraV1.motorcycle.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class FakeBrandLoader implements CommandLineRunner {

    private final BrandRepository brandRepository;

    @Override
    public void run(String... args) throws Exception {

        var yamaha = Brand.builder()
                .name("Yamaha")
                .build();

        var suzuki = Brand.builder()
                .name("Suzuki")
                .build();

        var honda = Brand.builder()
                .name("Honda")
                .build();

        brandRepository.saveAll(List.of(honda, suzuki, yamaha));

        log.info("Brands are saved, from FakeBrandLoader");

    }
}
