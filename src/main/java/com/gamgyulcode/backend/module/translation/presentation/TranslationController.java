package com.gamgyulcode.backend.module.translation.presentation;

import com.gamgyulcode.backend.global.config.LanguageConfig;
import com.gamgyulcode.backend.module.translation.domain.LanguageCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/languages")
public class TranslationController {

    @PostMapping("/set")
    public ResponseEntity<String> setLanguage(@RequestParam LanguageCode language) {
        LanguageConfig.setCurrentLanguage(language);
        return ResponseEntity.ok("Language changed to " + language);
    }
}