package com.yanader.new_music.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="year_sets")
@AllArgsConstructor
@NoArgsConstructor
public class YearSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="listening_year",columnDefinition = "SMALLINT")
    private Integer listeningYear;

    @Column(name="release_year",columnDefinition = "SMALLINT")
    private Integer releaseYear;
}
