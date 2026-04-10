package com.yanader.new_music.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Statistics {

    private List<Integer> years;
    private List<YearStats> yearStats;


    public Statistics(List<Album> albums, List<Integer> years) {
        this.years = years;
        yearStats = new ArrayList<>();
        generateStatistics(albums);
    }

    public void generateStatistics(List<Album> albums) {
        for (Integer year : this.years) {
            yearStats.add(new YearStats(year, albums));
        }
    }


}
