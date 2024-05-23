package com.gamgyulcode.backend.module.place.service;

import com.gamgyulcode.backend.global.config.LanguageConfig;
import com.gamgyulcode.backend.module.entity.domain.EntitiesRepository;
import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.place.domain.PlaceRepository;
import com.gamgyulcode.backend.module.place.dto.PlaceResponse;
import com.gamgyulcode.backend.module.translation.domain.LanguageCode;
import com.gamgyulcode.backend.module.translation.domain.TranslationRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final TranslationRepository translationRepository;
    private final EntitiesRepository entitiesRepository;

    // 테마 id에 따라서 모든 장소 제공
    public List<PlaceResponse> findAllPlacesByThemeId(Long themeId) {
        List<Place> places = placeRepository.findAllByThemeId(themeId);
        LanguageCode currentLanguage = LanguageConfig.getCurrentLanguage();

        return PlaceResponse.fromEntities(places, translationRepository, currentLanguage);
    }
}
