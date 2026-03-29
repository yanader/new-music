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
    @Column(name="artist_id")
    private Long artistId;
    @Column(name="set_id")
    private Long setId;
    @Column(columnDefinition = "SMALLINT")
    private Integer rating;
    private String notes;
    @Column(name="listened_on")
    private LocalDate listenedOn;
    @Column(name="spotify_album_id")
    private String spotifyAlbumId;
}
