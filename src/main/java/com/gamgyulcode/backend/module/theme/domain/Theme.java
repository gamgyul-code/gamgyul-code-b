package com.gamgyulcode.backend.module.theme.domain;

import com.gamgyulcode.backend.module.place.domain.Place;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theme_id")
    private Long id;

    private String themeName;

    @Builder.Default
    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    private List<Place> places = new ArrayList<>();
}