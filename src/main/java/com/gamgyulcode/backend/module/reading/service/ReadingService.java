package com.gamgyulcode.backend.module.reading.service;

import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.place.domain.PlaceRepository;
import com.gamgyulcode.backend.module.reading.domain.Reading;
import com.gamgyulcode.backend.module.reading.domain.ReadingRepository;
import com.gamgyulcode.backend.module.reading.dto.ReadingResponse;
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

    public ReadingResponse findFirst() {
        Place place = placeRepository.findById(2L)
                .orElseThrow(() -> new IllegalArgumentException("해당 장소가 없습니다."));

        Reading reading = readingRepository.findByPlaceName(place.getPlaceName());

        return ReadingResponse.fromEntity(reading, place);
    }
}
