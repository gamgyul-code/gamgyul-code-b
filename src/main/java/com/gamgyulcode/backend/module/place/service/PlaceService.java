package com.gamgyulcode.backend.module.place.service;

import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.place.domain.PlaceRepository;
import com.gamgyulcode.backend.module.place.dto.PlaceResponse;
import com.gamgyulcode.backend.module.reading.domain.Reading;
import com.gamgyulcode.backend.module.reading.domain.ReadingRepository;
import com.gamgyulcode.backend.module.theme.domain.Theme;
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
    private final ReadingRepository readingRepository;

    // 테마 id에 따라서 모든 장소 제공
    public List<PlaceResponse> findAllPlacesByThemeId(Long themeId) {
        List<Place> places = placeRepository.findAllByThemeId(themeId);

        return PlaceResponse.fromEntity(places);
    }
}
