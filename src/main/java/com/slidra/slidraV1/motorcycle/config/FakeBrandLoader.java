package com.slidra.slidraV1.motorcycle.config;

import com.slidra.slidraV1.motorcycle.enums.FuelType;
import com.slidra.slidraV1.motorcycle.enums.ModelCategory;
import com.slidra.slidraV1.motorcycle.model.Brand;
import com.slidra.slidraV1.motorcycle.model.Model;
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

        var yamahaMt = Model.builder()
                .name("Yamaha MT-07")
                .brand(yamaha)
                .yearFrom(2014)
                .yearTo(2023)
                .generation("1st Gen")
                .category(ModelCategory.STREET)
                .engineDisplacement(689)
                .horsepower(75)
                .weight(182.0)
                .fuelType(FuelType.PETROL)
                .build();

        var suzukiGsx = Model.builder()
                .name("Suzuki GSX-R1000")
                .brand(suzuki)
                .yearFrom(2001)
                .yearTo(2023)
                .generation("6th Gen")
                .category(ModelCategory.STREET)
                .engineDisplacement(999)
                .horsepower(200)
                .weight(202.0)
                .fuelType(FuelType.PETROL)
                .build();

        var hondaCBR = Model.builder()
                .name("CBR600RR")
                .brand(honda)
                .yearFrom(2003)
                .yearTo(2023)
                .generation("6th Gen")
                .category(ModelCategory.STREET)
                .engineDisplacement(599)
                .horsepower(118)
                .weight(196.0)
                .fuelType(FuelType.PETROL)
                .build();
        var hondaCBR1000 = Model.builder()
                .name("CBR1000")
                .brand(honda)
                .yearFrom(2003)
                .yearTo(2023)
                .generation("6th Gen")
                .category(ModelCategory.STREET)
                .engineDisplacement(599)
                .horsepower(118)
                .weight(196.0)
                .fuelType(FuelType.PETROL)
                .build();


        honda.setModels(List.of(hondaCBR, hondaCBR1000));
        suzuki.setModels(List.of(suzukiGsx));
        yamaha.setModels(List.of(yamahaMt));

        brandRepository.saveAll(List.of(honda, suzuki, yamaha));

        log.info("Brands are saved, from FakeBrandLoader");

    }
}
