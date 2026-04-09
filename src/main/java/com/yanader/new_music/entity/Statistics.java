package com.yanader.new_music.entity;

import com.yanader.new_music.service.YearSetService;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    List<Integer> years;
    List<YearStats> yearStats;
    List<Album> albums;

    public Statistics(List<Album> albums, List<Integer> years) {
        this.years = years;
        yearStats = new ArrayList<>();
        this.albums = albums;
    }

    public void generateStatistics() {
        for (Integer year : this.years) {
            yearStats.add(new YearStats(year, this.albums));
        }
    }


}
