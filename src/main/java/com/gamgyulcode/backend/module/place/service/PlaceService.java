package com.gamgyulcode.backend.module.place.service;

import com.gamgyulcode.backend.module.place.domain.PlaceRepository;
import com.gamgyulcode.backend.module.theme.domain.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;



}
