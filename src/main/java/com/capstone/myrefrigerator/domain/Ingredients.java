package com.capstone.myrefrigerator.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredients_id")
    private Long id;

    private String name;

    private String url;

    @JoinColumn(name = "recipe_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;
}
