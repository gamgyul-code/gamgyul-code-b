package com.gamgyulcode.backend.module.reading.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@AllArgsConstructor
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reading_id")
    private Long id;

    private String readingPlaceName;

    private String placePictureUrl;

    private String phoneNumber;

    private String fee;

    @Column(length = 1000)
    private String tale;

    private String terrain;

    private String caution;

    private String history;

    private String originate;

    private String time;

    private String introText;
}