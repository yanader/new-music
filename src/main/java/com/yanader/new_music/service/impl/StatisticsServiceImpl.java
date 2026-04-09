package com.yanader.new_music.service.impl;

import com.yanader.new_music.entity.Album;
import com.yanader.new_music.entity.Statistics;
import com.yanader.new_music.service.StatisticsService;
import com.yanader.new_music.service.YearSetService;

import java.util.List;

public class StatisticsServiceImpl implements StatisticsService {

    private final YearSetService yearSetService;
    private List<Album> albums;

    public StatisticsServiceImpl(YearSetService yearSetService, List<Album> albums) {
        this.yearSetService = yearSetService;
        this.albums = albums;
    }

    @Override
    public List<Integer> getDistinctListeningYears() {
        return yearSetService.getAllListeningYears();
    }

    @Override
    public List<Integer> getDistinctReleaseYears() {
        return yearSetService.getAllReleaseYears();
    }

    @Override
    public Statistics getStatistics(List<Album> albums) {
        return new Statistics(albums, getDistinctListeningYears());
    }
}
