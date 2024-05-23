package com.gamgyulcode.backend.module.translation.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<Translation, Long> {
    Optional<Translation> findByEntityIdAndFieldNameAndLanguageCode(Long entityId, String fieldName, LanguageCode languageCode);
}
