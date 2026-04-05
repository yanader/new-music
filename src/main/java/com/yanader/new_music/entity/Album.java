package com.yanader.new_music.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name="albums")
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="artist_id")
    private Artist artist;

    private String name;

    @ManyToOne
    @JoinColumn(name="set_id")
    private YearSet yearSet;

    @Column(columnDefinition = "SMALLINT")
    private Integer rating;

    private String notes;

    @Column(name="listened_on")
    private LocalDate listenedOn;

    @Column(name="spotify_album_id")
    private String spotifyAlbumId;
}
