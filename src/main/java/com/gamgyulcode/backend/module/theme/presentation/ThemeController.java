package com.gamgyulcode.backend.module.theme.presentation;

import com.gamgyulcode.backend.module.theme.dto.ThemeResponse;
import com.gamgyulcode.backend.module.theme.service.ThemeService;
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
@RequestMapping("/themes")
public class ThemeController {

    private final ThemeService themeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ThemeResponse findAllThemes() {
        return themeService.findAllThemes();
    }
}
