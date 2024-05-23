package com.gamgyulcode.backend.module.place.domain;

import com.gamgyulcode.backend.module.theme.domain.Theme;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;

    private String placeName;

    private String placeAddress;

    private String locationX;

    private String locationY;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")@Enumerated(EnumType.STRING)
    private Theme theme;
}