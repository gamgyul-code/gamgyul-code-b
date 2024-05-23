package com.gamgyulcode.backend.global.config;

import com.gamgyulcode.backend.module.translation.domain.LanguageCode;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class LanguageConfig {

    @Getter
    private static LanguageCode currentLanguage = LanguageCode.KO; // 기본 언어 설정

    public static void setCurrentLanguage(LanguageCode language) {
        currentLanguage = language;
    }
}