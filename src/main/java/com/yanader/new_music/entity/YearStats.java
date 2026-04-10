package com.yanader.new_music.entity;

import com.yanader.new_music.utils.StatsUtil;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class YearStats {
    private final Integer year;
    private final Integer count;
    private Integer countSevenPlus;
    private Double percentSevenPlus;
    private Double mean;
    private Integer mode;
    private Double median;
    private Double stdDev;

    public YearStats(Integer year, List<Album> albums) {
        this.year = year;
        List<Album> yearAlbums = albums.stream()
                .filter(a -> a.getYearSet() != null
                        && a.getYearSet().getListeningYear() != null
                        && a.getYearSet().getListeningYear().equals(year))
                .toList();
        this.count = yearAlbums.size();
        this.countSevenPlus = 0;
        processAlbums(yearAlbums);
    }

    private void processAlbums(List<Album> albums) {
        List<Album> filteredAlbums = albums.stream().filter(album -> album.getRating() != null).toList();
        List<Integer> ratings = filteredAlbums.stream().map(Album::getRating).toList();

        for (Integer rating: ratings) {
            if (rating >= 7) {
                this.countSevenPlus++;
            }
        }
        this.percentSevenPlus = this.count == 0 ? 0.0 : this.countSevenPlus * 1.0 / this.count;
        this.mean = StatsUtil.mean(ratings);
        this.mode = StatsUtil.mode(ratings);
        this.median = StatsUtil.median(ratings);
        this.stdDev = StatsUtil.stdDev(ratings);
    }
}
