package com.gamgyulcode.backend.module.reading.service;

import com.gamgyulcode.backend.global.config.LanguageConfig;
import com.gamgyulcode.backend.module.entity.domain.EntitiesRepository;
import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.place.domain.PlaceRepository;
import com.gamgyulcode.backend.module.reading.domain.Reading;
import com.gamgyulcode.backend.module.reading.domain.ReadingRepository;
import com.gamgyulcode.backend.module.reading.dto.ReadingResponse;
import com.gamgyulcode.backend.module.translation.domain.LanguageCode;
import com.gamgyulcode.backend.module.translation.domain.TranslationRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReadingService {

    private final ReadingRepository readingRepository;
    private final PlaceRepository placeRepository;
    private final TranslationRepository translationRepository;
    private final EntitiesRepository entitiesRepository;

    public ReadingResponse findFirst() {
        Place place = placeRepository.findById(2L)
                .orElseThrow(() -> new IllegalArgumentException("해당 장소가 없습니다."));

        Optional<Reading> reading = readingRepository.findByReadingPlaceName(place.getPlaceName());
        LanguageCode currentLanguage = LanguageConfig.getCurrentLanguage();

        return reading.map(r -> ReadingResponse.fromEntity(r, place, translationRepository, currentLanguage))
                .orElseThrow(() -> new IllegalArgumentException("해당 읽을거리가 없습니다."));
    }

    public ReadingResponse find(Long placeId) {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 장소가 없습니다."));

        Optional<Reading> reading = readingRepository.findById(placeId);
        LanguageCode currentLanguage = LanguageConfig.getCurrentLanguage();

        return reading.map(r -> ReadingResponse.fromEntity(r, place, translationRepository, currentLanguage))
                .orElseThrow(() -> new IllegalArgumentException("해당 읽을거리가 없습니다."));
    }

    public ReadingResponse findMapIntro(Long placeId) {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 장소가 없습니다."));

        Optional<Reading> reading = readingRepository.findByReadingPlaceName(place.getPlaceName());
        LanguageCode currentLanguage = LanguageConfig.getCurrentLanguage();

        return reading.map(r -> ReadingResponse.fromEntity(r, translationRepository, currentLanguage))
                .orElseThrow(() -> new IllegalArgumentException("해당 읽을거리가 없습니다."));
    }
}