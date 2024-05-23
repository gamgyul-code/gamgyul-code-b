package com.gamgyulcode.backend.module.place.presentation;

import com.gamgyulcode.backend.module.place.dto.PlaceResponse;
import com.gamgyulcode.backend.module.place.service.PlaceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/themePlaces")
    public List<PlaceResponse> findThemePlaces() {
        return placeService.findAllPlacesByThemeId(1L);
    }
}
