package com.gamgyulcode.backend.module.translation.domain;

import com.gamgyulcode.backend.module.entity.domain.EntityType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "translation_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    @Enumerated(EnumType.STRING)
    private LanguageCode languageCode;

    private String fieldName;

    @Column(columnDefinition = "TEXT")
    private String text;

    private Long entityId;
}