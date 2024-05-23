package com.gamgyulcode.backend.module.theme.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ThemeResponse {

    private List<String> themes;

    public static ThemeResponse fromEntity(List<String> themes) {
        return ThemeResponse.builder()
                .themes(themes)
                .build();
    }
}
