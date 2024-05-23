package com.gamgyulcode.backend.module.place.dto;

import com.gamgyulcode.backend.module.entity.domain.Entities;
import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.reading.domain.Reading;
import com.gamgyulcode.backend.module.translation.domain.LanguageCode;
import com.gamgyulcode.backend.module.translation.domain.Translation;
import com.gamgyulcode.backend.module.translation.domain.TranslationRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PlaceResponse {

    private Long id;

    private String placeName;

    private String locationX;

    private String locationY;

    public static List<PlaceResponse> fromEntities(List<Place> places, TranslationRepository translationRepository, LanguageCode currentLanguage) {
        return places.stream().map(place -> {
            String translatedName = translationRepository.findByEntityIdAndFieldNameAndLanguageCode(place.getId(), "placeName", currentLanguage)
                    .map(Translation::getText)
                    .orElse(place.getPlaceName());

            return PlaceResponse.builder()
                    .id(place.getId())
                    .placeName(translatedName)
                    .locationX(place.getLocationX())
                    .locationY(place.getLocationY())
                    .build();
        }).collect(Collectors.toList());
    }
}
