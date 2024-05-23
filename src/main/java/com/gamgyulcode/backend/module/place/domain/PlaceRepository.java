package com.gamgyulcode.backend.module.place.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByThemeId(Long themeId);
}
