package com.gamgyulcode.backend.global.config;

import static com.gamgyulcode.backend.module.place.domain.Area.SEOQWIPO_CITY;

import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.place.domain.PlaceRepository;
import com.gamgyulcode.backend.module.theme.domain.Theme;
import com.gamgyulcode.backend.module.theme.domain.ThemeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(ThemeRepository themeRepository, PlaceRepository placeRepository) {
        return args -> {
            Theme theme1 = Theme.builder().themeName("설문대 할망").build();
            Theme theme2 = Theme.builder().themeName("역사").build();
            Theme theme3 = Theme.builder().themeName("신화").build();
            Theme theme4 = Theme.builder().themeName("사랑").build();

            themeRepository.save(theme1);
            themeRepository.save(theme2);
            themeRepository.save(theme3);
            themeRepository.save(theme4);

            // Create Place
            Place place1 = Place.builder().placeName("영실기암").placeAddress("제주 서귀포시 하원동 산1-4")
                    .locationX("126.498473").locationY("126.498473")
                    .theme(theme1)
                    .build();

            placeRepository.save(place1);
            theme1.getPlaces().add(place1);
            themeRepository.save(theme1);

        };
    }
}