package com.gamgyulcode.backend.module.theme.service;

import com.gamgyulcode.backend.module.theme.domain.Theme;
import com.gamgyulcode.backend.module.theme.domain.ThemeRepository;
import com.gamgyulcode.backend.module.theme.dto.ThemeResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ThemeService {

    private final ThemeRepository themeRepository;

    @Transactional(readOnly = true)
    public ThemeResponse findAllThemes() {

        List<Theme> themes = themeRepository.findAll();

        List<String> responses = themes.stream()
                .map(Theme::getThemeName)
                .collect(Collectors.toList());

        return ThemeResponse.fromEntity(responses);
    }
}
