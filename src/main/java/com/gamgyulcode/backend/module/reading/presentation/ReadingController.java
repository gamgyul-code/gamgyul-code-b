package com.gamgyulcode.backend.module.reading.presentation;

import com.gamgyulcode.backend.module.reading.dto.ReadingResponse;
import com.gamgyulcode.backend.module.reading.service.ReadingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/readings")
public class ReadingController {
    private final ReadingService readingService;

    @GetMapping("/intro")
    public ReadingResponse findFirstReading() {
        return readingService.findFirst();
    }

    @GetMapping("/mapIntro/{placeId}")
    public ReadingResponse findMapIntro(@PathVariable Long placeId) {
        return readingService.findMapIntro(placeId);
    }
}
