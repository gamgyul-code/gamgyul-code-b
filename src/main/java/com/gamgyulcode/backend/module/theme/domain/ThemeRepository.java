package com.gamgyulcode.backend.module.theme.domain;

import com.gamgyulcode.backend.module.place.domain.Place;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
