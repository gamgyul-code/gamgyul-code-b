package com.gamgyulcode.backend.module.reading.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<Reading, Long> {
    Optional<Reading> findByReadingPlaceName(String placeName);

}
