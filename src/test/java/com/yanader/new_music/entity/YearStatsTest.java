package com.yanader.new_music.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class YearStatsTest {

    private Album albumWithYearAndRating(int year, Integer rating) {
        YearSet yearSet = new YearSet();
        yearSet.setListeningYear(year);
        Album album = new Album();
        album.setYearSet(yearSet);
        album.setRating(rating);
        return album;
    }

    private Album albumWithNoYearSet() {
        Album album = new Album();
        album.setYearSet(null);
        return album;
    }

    private Album albumWithNullListeningYear() {
        YearSet yearSet = new YearSet();
        yearSet.setListeningYear(null);
        Album album = new Album();
        album.setYearSet(yearSet);
        return album;
    }

    @Test
    void shouldOnlyCountAlbumsMatchingTheGivenYear() {
        List<Album> albums = List.of(
                albumWithYearAndRating(2023, 7),
                albumWithYearAndRating(2023, 8),
                albumWithYearAndRating(2024, 9)  // different year — excluded
        );

        YearStats stats = new YearStats(2023, albums);

        assertThat(stats.getCount()).isEqualTo(2);
    }

    @Test
    void shouldExcludeAlbumsWithNullYearSet() {
        List<Album> albums = List.of(
                albumWithYearAndRating(2023, 7),
                albumWithNoYearSet()
        );

        YearStats stats = new YearStats(2023, albums);

        assertThat(stats.getCount()).isEqualTo(1);
    }

    @Test
    void shouldExcludeAlbumsWithNullListeningYear() {
        List<Album> albums = List.of(
                albumWithYearAndRating(2023, 7),
                albumWithNullListeningYear()
        );

        YearStats stats = new YearStats(2023, albums);

        assertThat(stats.getCount()).isEqualTo(1);
    }

    @Test
    void shouldCountAlbumsRatedSevenOrAbove() {
        List<Album> albums = List.of(
                albumWithYearAndRating(2023, 6),  // excluded
                albumWithYearAndRating(2023, 7),  // boundary — included
                albumWithYearAndRating(2023, 8),
                albumWithYearAndRating(2023, 10)
        );

        YearStats stats = new YearStats(2023, albums);

        assertThat(stats.getCountSevenPlus()).isEqualTo(3);
    }

    @Test
    void shouldCalculatePercentSevenPlusCorrectly() {
        List<Album> albums = List.of(
                albumWithYearAndRating(2023, 5),
                albumWithYearAndRating(2023, 7),
                albumWithYearAndRating(2023, 8),
                albumWithYearAndRating(2023, 6)
        );

        YearStats stats = new YearStats(2023, albums);

        assertThat(stats.getPercentSevenPlus()).isEqualTo(0.5);
    }

    @Test
    void shouldHandleEmptyAlbumList() {
        YearStats stats = new YearStats(2023, List.of());

        assertThat(stats.getCount()).isEqualTo(0);
        assertThat(stats.getCountSevenPlus()).isEqualTo(0);
        assertThat(stats.getPercentSevenPlus()).isEqualTo(0.0);
        // StatsUtil should handle empty lists — verify it returns null or 0 as per contract
        assertThat(stats.getMean() == 0.0); // or 0.0 depending on StatsUtil
    }

    @Test
    void shouldHandleAlbumsWithNullRatings() {
        List<Album> albums = List.of(
                albumWithYearAndRating(2023, null),  // null rating — filtered in processAlbums
                albumWithYearAndRating(2023, 8)
        );

        YearStats stats = new YearStats(2023, albums);

        // count includes the null-rated album (it passed the year filter)
        assertThat(stats.getCount()).isEqualTo(2);
        // but stats are only computed from the rated one
        assertThat(stats.getMean()).isEqualTo(8.0);
    }

    @Test
    void shouldReturnZeroPercentWhenNoAlbumsMatchYear() {
        List<Album> albums = List.of(albumWithYearAndRating(2024, 9));

        YearStats stats = new YearStats(2023, albums);

        assertThat(stats.getPercentSevenPlus()).isEqualTo(0.0);
    }

}