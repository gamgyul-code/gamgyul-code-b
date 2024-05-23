package com.gamgyulcode.backend.module.place.dto;

import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.reading.domain.Reading;
import java.util.List;
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

    public static List<PlaceResponse> fromEntity(List<Place> places) {
        return places.stream().map(place -> PlaceResponse.builder()
                .id(place.getId())
                .placeName(place.getPlaceName())
                .locationX(place.getLocationX())
                .locationY(place.getLocationY())
                .build())
                .toList();
    }

}
