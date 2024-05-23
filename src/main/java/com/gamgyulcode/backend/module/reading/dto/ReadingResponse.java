package com.gamgyulcode.backend.module.reading.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.reading.domain.Reading;
import com.gamgyulcode.backend.module.translation.domain.LanguageCode;
import com.gamgyulcode.backend.module.translation.domain.Translation;
import com.gamgyulcode.backend.module.translation.domain.TranslationRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadingResponse {
    private Long id;

    private String name;

    private String placePictureUrl;

    private String address;

    private String phoneNumber;

    private String fee;

    private String tale;

    private String terrain;

    private String caution;

    private String history;

    private String time;

    private String introText;

    private Long themeId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static ReadingResponse fromEntity(Reading reading, Place place, TranslationRepository translationRepository, LanguageCode currentLanguage) {
        return ReadingResponse.builder()
                .id(reading.getId())
                .name(getTranslatedText(translationRepository, reading.getId(), "readingPlaceName", reading.getReadingPlaceName(), currentLanguage))
                .placePictureUrl(reading.getPlacePictureUrl())
                .address(getTranslatedText(translationRepository, reading.getId(), "placeAddress", place.getPlaceAddress(), currentLanguage))
                .phoneNumber(reading.getPhoneNumber())
                .fee(getTranslatedText(translationRepository, reading.getId(), "fee", reading.getFee(), currentLanguage))
                .tale(getTranslatedText(translationRepository, reading.getId(), "tale", reading.getTale(), currentLanguage))
                .terrain(getTranslatedText(translationRepository, reading.getId(), "terrain", reading.getTerrain(), currentLanguage))
                .caution(getTranslatedText(translationRepository, reading.getId(), "caution", reading.getCaution(), currentLanguage))
                .history(getTranslatedText(translationRepository, reading.getId(), "history", reading.getHistory(), currentLanguage))
                .time(getTranslatedText(translationRepository, reading.getId(), "time", reading.getTime(), currentLanguage))
                .introText(getTranslatedText(translationRepository, reading.getId(), "introText", reading.getIntroText(), currentLanguage))
                .themeId(place.getTheme().getId())
                .build();
    }

    public static ReadingResponse fromEntity(Reading reading, TranslationRepository translationRepository, LanguageCode currentLanguage) {
        return ReadingResponse.builder()
                .id(reading.getId())
                .name(getTranslatedText(translationRepository, reading.getId(), "readingPlaceName", reading.getReadingPlaceName(), currentLanguage))
                .introText(getTranslatedText(translationRepository, reading.getId(), "introText", reading.getIntroText(), currentLanguage))
                .placePictureUrl(reading.getPlacePictureUrl())
                .build();
    }

    private static String getTranslatedText(TranslationRepository translationRepository, Long entityId, String fieldName, String defaultText, LanguageCode languageCode) {
        return translationRepository.findByEntityIdAndFieldNameAndLanguageCode(entityId, fieldName, languageCode)
                .map(Translation::getText)
                .orElse(defaultText);
    }
}
