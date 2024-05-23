package com.gamgyulcode.backend.module.reading.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<Reading, Long> {
    Reading findByPlaceName(String placeName);
}
