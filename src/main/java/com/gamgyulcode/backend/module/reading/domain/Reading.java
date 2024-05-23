package com.gamgyulcode.backend.module.reading.domain;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(columnDefinition = "TEXT")
    private String tale;

    private String terrain;

    private String caution;

    private String history;

    private String originate;

    private String time;

    private String introText;
}