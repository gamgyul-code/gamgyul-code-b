package com.gamgyulcode.backend.module.reading.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.reading.domain.Reading;
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

    private String address;

    private String phoneNumber;

    private String fee;

    private String tale;

    private String terrain;

    private String caution;

    private String history;

    private String time;

    public static ReadingResponse fromEntity(Reading reading, Place place) {
        return ReadingResponse.builder()
                .id(reading.getId())
                .name(reading.getPlaceName())
                .address(place.getPlaceAddress())
                .phoneNumber(reading.getPhoneNumber())
                .fee(reading.getFee())
                .tale(reading.getTale())
                .terrain(reading.getTerrain())
                .caution(reading.getCaution())
                .history(reading.getHistory())
                .time(reading.getTime())
                .build();
    }
}
