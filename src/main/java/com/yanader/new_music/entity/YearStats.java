package com.yanader.new_music.entity;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class YearStats {
    private Integer year;
    private Integer count;
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
        int sum = 0;
        List<Album> filteredAlbums = albums.stream().filter(album -> album.getRating() != null).toList();
        Map<Integer, Integer> scores = new HashMap<>();

        for (Album album: filteredAlbums) {
            Integer rating = album.getRating();
            if (rating >= 7) {
                this.countSevenPlus++;
            }
            sum += rating;
            scores.put(rating, scores.getOrDefault(rating, 0) + 1);
        }
        this.percentSevenPlus = this.count == 0 ? 0.0 : this.countSevenPlus * 1.0 / this.count;

        this.mean = sum * 1.0 / this.count;

        int tempMode = -1;
        int maxCount = -1;

        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                tempMode = entry.getKey();
            }
        }

        this.mode = tempMode;
        this.median = median(filteredAlbums);
        this.stdDev = stdDev(filteredAlbums);

    }

    public Double median(List<Album> albums) {
        List<Integer> ratings = albums.stream().map(Album::getRating).sorted().toList();

        int size = ratings.size();
        if (size == 0) return 0.0;
        if (size % 2 == 1) {
            return ratings.get(size/2) * 1.0;
        } else {
            return (ratings.get(size / 2 - 1) + ratings.get(size / 2)) / 2.0;
        }
    }

    private Double stdDev(List<Album> albums){
        List<Integer> ratings = albums.stream().map(Album::getRating).toList();
        if (ratings.size() < 2) return 0.0;

        double mean = ratings.stream().mapToDouble(i -> i).average().orElse(0.0);

        double variance = 0.0;
        for (int num : ratings) {
            variance += Math.pow(num - mean, 2);
        }
        variance /= (ratings.size() - 1);

        return Math.sqrt(variance);
    }

}
