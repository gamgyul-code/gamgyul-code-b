package com.gamgyulcode.backend.module.entity.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntitiesRepository extends JpaRepository<Entities, Long> {
    Entities findByEntityName(String entityName);
}
